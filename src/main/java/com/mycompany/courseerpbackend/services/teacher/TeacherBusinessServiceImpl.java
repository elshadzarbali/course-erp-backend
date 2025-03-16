package com.mycompany.courseerpbackend.services.teacher;

import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import com.mycompany.courseerpbackend.models.mappers.UserEntityMapper;
import com.mycompany.courseerpbackend.models.mybatis.teacher.Teacher;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.payload.teacher.TeacherPayload;
import com.mycompany.courseerpbackend.services.role.RoleService;
import com.mycompany.courseerpbackend.services.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;
import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.PHONE_NUMBER_ALREADY_EXIST;
import static com.mycompany.courseerpbackend.utils.CommonUtils.throwIf;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherBusinessServiceImpl implements  TeacherBusinessService {

    final TeacherService teacherService;
    final UserService userService;
    final RoleService roleService;
    final PasswordEncoder passwordEncoder;

    // TODO: Assign process for groups
    @Override
    public void createTeacher(TeacherPayload teacherPayload) {
        throwIf(
                () -> userService.checkByPhoneNumber(teacherPayload.getPhoneNumber()),
                ExceptionBuilder.of(PHONE_NUMBER_ALREADY_EXIST)
        );

        throwIf(
                () -> userService.checkByEmail(teacherPayload.getEmail()),
                ExceptionBuilder.of(EMAIL_ALREADY_REGISTERED)
        );

        // TODO: We will change role id in future
        Long defaultRoleId = roleService.getDefaultRole().getId();


        // TODO: We will change passwordn in future
        String encryptedPassword = passwordEncoder.encode("123456789");
        User newUser = UserEntityMapper.INSTANCE.fromTeacherPayloadToUser(
                teacherPayload, encryptedPassword, defaultRoleId
        );
        userService.insert(newUser);

        teacherService.insert(Teacher.builder().id(newUser.getId()).build());
    }

}
