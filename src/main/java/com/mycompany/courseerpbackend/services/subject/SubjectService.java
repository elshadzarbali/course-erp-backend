package com.mycompany.courseerpbackend.services.subject;

import com.mycompany.courseerpbackend.models.mybatis.subject.Subject;

import java.util.List;

public interface SubjectService {

    void insert(Subject subject);

    void update(Subject subject);

    Subject findById(Long id);

    List<Subject> findAll();

}
