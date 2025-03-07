package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.teacher.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TeacherRepository {

    void insert(Teacher teacher);

    void update(Teacher teacher);

    //  It is not required to use @Param, because of mybatis will use field name by default,
    //  if we don't specify a name. But, writing @Param is recommended
    Optional<Teacher> findById(@Param("id") Long id);

    List<Teacher> findAll();

}
