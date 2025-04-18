package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpPayload;
import com.mycompany.courseerpbackend.models.payload.student.StudentPayload;
import com.mycompany.courseerpbackend.models.payload.teacher.TeacherPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    @Mapping(target = "password", source = "encryptedPassword")
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "roleId", source = "roleId")
    User fromSignUpPayloadToUser(SignUpPayload payload, String encryptedPassword, Long roleId);

    @Mapping(target = "password", source = "encryptedPassword")
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "roleId", source = "roleId")
    User fromStudentPayloadToUser(StudentPayload payload, String encryptedPassword, Long roleId);

    @Mapping(target = "password", source = "encryptedPassword")
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "roleId", source = "roleId")
    User fromTeacherPayloadToUser(TeacherPayload payload, String encryptedPassword, Long roleId);

}
