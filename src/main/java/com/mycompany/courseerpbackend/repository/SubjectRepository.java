package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.subject.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SubjectRepository {

    void insert(Subject subject);

    void update(Subject subject);

    Optional<Subject> findById(@Param("id") Long id);

    List<Subject> findAll();

}
