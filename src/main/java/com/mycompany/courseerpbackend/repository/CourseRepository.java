package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.course.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseRepository {

    void insert(Course course);

}
