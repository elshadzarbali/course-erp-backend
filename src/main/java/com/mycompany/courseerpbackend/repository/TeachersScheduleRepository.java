package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.teacher.TeachersSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TeachersScheduleRepository {

    void insert(TeachersSchedule teachersSchedule);

//    void upsert(@Param("schedules") List<TeachersSchedule> schedules);

    void update(TeachersSchedule teachersSchedule);

    Optional<TeachersSchedule> findById(@Param("id") Long id);

    List<TeachersSchedule> findAll();

}
