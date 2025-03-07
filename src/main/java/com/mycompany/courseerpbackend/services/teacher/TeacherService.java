package com.mycompany.courseerpbackend.services.teacher;

import com.mycompany.courseerpbackend.models.mybatis.teacher.Teacher;

import java.util.List;

public interface TeacherService {

    void insert(Teacher teacher);

    void update(Teacher teacher);

    Teacher findById(Long id);

    List<Teacher> findAll();

}
