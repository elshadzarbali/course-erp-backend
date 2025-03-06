package com.mycompany.courseerpbackend.services.student;

import com.mycompany.courseerpbackend.models.mybatis.student.Student;

import java.util.List;

public interface StudentService {

    void insert(Student student);

    void update(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void addStudentToGroup(Long studentId, Long groupId);

    boolean checkStudentAlreadyAddedToGroup(Long studentId, Long groupId);

}
