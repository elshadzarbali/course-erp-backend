package com.mycompany.courseerpbackend.services.student;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.mappers.UserEntityMapper;
import com.mycompany.courseerpbackend.models.mybatis.role.Role;
import com.mycompany.courseerpbackend.models.mybatis.student.Student;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.payload.student.StudentPayload;
import com.mycompany.courseerpbackend.services.role.RoleService;
import com.mycompany.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.PHONE_NUMBER_ALREADY_EXIST;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentBusinessServiceImpl implements StudentBusinessService {

    private final StudentService studentService;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    // TODO: Assign process for groups
    @Override
    public void addStudent(StudentPayload studentPayload) {
        if (userService.checkByPhoneNumber(studentPayload.getPhoneNumber())) {
            throw BaseException.of(PHONE_NUMBER_ALREADY_EXIST);
        }

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

}
