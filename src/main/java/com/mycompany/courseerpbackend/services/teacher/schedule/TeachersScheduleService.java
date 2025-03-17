package com.mycompany.courseerpbackend.services.teacher.schedule;

import com.mycompany.courseerpbackend.models.mybatis.teacher.TeachersSchedule;

import java.util.List;

public interface TeachersScheduleService {

    void insert(TeachersSchedule teachersSchedule);

//    void upsert(List<TeachersSchedule> schedules);

    void update(TeachersSchedule teachersSchedule);

    TeachersSchedule findById(Long id);

    List<TeachersSchedule> findAll();

}
