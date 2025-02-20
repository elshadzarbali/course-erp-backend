package com.mycompany.courseerpbackend.services.subject;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.mybatis.subject.Subject;
import com.mycompany.courseerpbackend.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public void insert(Subject subject) {
        subjectRepository.insert(subject);
    }

    @Override
    public void update(Subject subject) {
        subjectRepository.update(subject);
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Subject.class.getSimpleName(), "id", String.valueOf(id))
        );
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

}
