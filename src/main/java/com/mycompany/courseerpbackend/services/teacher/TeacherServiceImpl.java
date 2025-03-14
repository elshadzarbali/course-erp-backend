package com.mycompany.courseerpbackend.services.teacher;

import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import com.mycompany.courseerpbackend.models.mybatis.teacher.Teacher;
import com.mycompany.courseerpbackend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public void insert(Teacher teacher) {
        teacherRepository.insert(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepository.update(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElseThrow(
                () -> ExceptionBuilder.notFound(Teacher.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

}
