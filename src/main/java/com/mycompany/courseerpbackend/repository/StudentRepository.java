package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.student.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentRepository {

    void insert(Student student);

    void update(Student student);

    Optional<Student> findById(@Param("id") Long id);

    List<Student> findAll();

    void addStudentToGroup(@Param("studentId") Long studentId, @Param("groupId") Long groupId);

    boolean checkStudentAlreadyAddedToGroup(@Param("studentId") Long studentId, @Param("groupId") Long groupId);

}
