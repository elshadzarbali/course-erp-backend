package com.mycompany.courseerpbackend.services.teacher;

import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import com.mycompany.courseerpbackend.models.mybatis.teacher.TeachersSchedule;
import com.mycompany.courseerpbackend.repository.TeachersScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeachersScheduleServiceImpl implements TeachersScheduleService {

    private final TeachersScheduleRepository teachersScheduleRepository;

    @Override
    public void insert(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.insert(teachersSchedule);
    }

    @Override
    public void update(TeachersSchedule teachersSchedule) {
        teachersScheduleRepository.update(teachersSchedule);
    }

    @Override
    public TeachersSchedule findById(Long id) {
        return teachersScheduleRepository.findById(id).orElseThrow(
                () -> ExceptionBuilder.notFound(TeachersSchedule.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public List<TeachersSchedule> findAll() {
        return teachersScheduleRepository.findAll();
    }
}
