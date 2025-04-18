package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.course.Course;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseEntityMapper {

    CourseEntityMapper INSTANCE = Mappers.getMapper(CourseEntityMapper.class);

    @Mapping(target = "name", source = "courseName")
    @Mapping(target = "status", constant = "ACTIVE")
    Course fromSignUpPayload(SignUpPayload signUpPayload);

}
