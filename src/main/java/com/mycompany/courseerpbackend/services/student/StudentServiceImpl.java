package com.mycompany.courseerpbackend.services.student;

import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import com.mycompany.courseerpbackend.models.mybatis.student.Student;
import com.mycompany.courseerpbackend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void insert(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> ExceptionBuilder.notFound(Student.class.getSimpleName(), "id", String.valueOf(id))
        );
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudentToGroup(Long studentId, Long groupId) {
        studentRepository.addStudentToGroup(studentId, groupId);
    }

    @Override
    public boolean checkStudentAlreadyAddedToGroup(Long studentId, Long groupId) {
        return studentRepository.checkStudentAlreadyAddedToGroup(studentId, groupId);
    }

}
