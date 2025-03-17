package com.mycompany.courseerpbackend.models.mappers;

import com.mycompany.courseerpbackend.models.mybatis.teacher.TeachersSchedule;
import com.mycompany.courseerpbackend.models.payload.teacher.schedule.TeacherSchedulePayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.DayOfWeek;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeachersScheduleMapper {

    TeachersScheduleMapper INSTANCE = Mappers.getMapper(TeachersScheduleMapper.class);

    @Mapping(target = "teacherId", source = "teacherId")
    @Mapping(target = "dayOfWeek", source = "dayOfWeek")
    TeachersSchedule toEntity(TeacherSchedulePayload.TeacherScheduleData data, Long teacherId, DayOfWeek dayOfWeek);

}
