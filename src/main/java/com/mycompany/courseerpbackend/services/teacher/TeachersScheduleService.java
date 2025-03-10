package com.mycompany.courseerpbackend.services.teacher;

import com.mycompany.courseerpbackend.models.mybatis.teacher.TeachersSchedule;

import java.util.List;

public interface TeachersScheduleService {

    void insert(TeachersSchedule teachersSchedule);

    void update(TeachersSchedule teachersSchedule);

    TeachersSchedule findById(Long id);

    List<TeachersSchedule> findAll();

}
