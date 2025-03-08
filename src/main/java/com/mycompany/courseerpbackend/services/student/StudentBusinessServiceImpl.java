package com.mycompany.courseerpbackend.services.student;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages;
import com.mycompany.courseerpbackend.models.mappers.UserEntityMapper;
import com.mycompany.courseerpbackend.models.mybatis.role.Role;
import com.mycompany.courseerpbackend.models.mybatis.student.Student;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.payload.student.StudentPayload;
import com.mycompany.courseerpbackend.services.group.GroupService;
import com.mycompany.courseerpbackend.services.role.RoleService;
import com.mycompany.courseerpbackend.services.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.PHONE_NUMBER_ALREADY_EXIST;
import static com.mycompany.courseerpbackend.utils.CommonUtils.throwIf;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentBusinessServiceImpl implements StudentBusinessService {

    final StudentService studentService;
    final UserService userService;
    final RoleService roleService;
    final PasswordEncoder passwordEncoder;
    final GroupService groupService;

    // TODO: Assign process for groups
    @Override
    public void addStudent(StudentPayload studentPayload) {
        throwIf(
                () -> userService.checkByPhoneNumber(studentPayload.getPhoneNumber()),
                BaseException.of(PHONE_NUMBER_ALREADY_EXIST)
        );

        // TODO: We will change role
        Role defaultRole = roleService.getDefaultRole();

        // TODO: We will change password
        String password = "123456789";
        String encryptedPassword = passwordEncoder.encode(password);

        User user = UserEntityMapper.INSTANCE.fromStudentPayloadToUser(
                studentPayload, encryptedPassword, defaultRole.getId()
        );
        userService.insert(user);

        studentService.insert(Student.builder().userId(user.getId()).build());
    }

    @Override
    public void addStudentToGroup(Long studentId, Long groupId) {
        // checking existing of Student and Group
        studentService.findById(studentId);
        groupService.findById(groupId);

        // checking if students already added to group
        throwIf(
                () -> studentService.checkStudentAlreadyAddedToGroup(studentId, groupId),
                BaseException.of(ErrorResponseMessages.STUDENT_ALREADY_ADDED_TO_GROUP)
        );

        studentService.addStudentToGroup(studentId, groupId);
    }

}
