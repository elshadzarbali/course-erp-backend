package com.mycompany.courseerpbackend.services.course;

import com.mycompany.courseerpbackend.models.mybatis.course.Course;
import com.mycompany.courseerpbackend.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void insertCourse(Course course) {
        courseRepository.insert(course);
    }
}
