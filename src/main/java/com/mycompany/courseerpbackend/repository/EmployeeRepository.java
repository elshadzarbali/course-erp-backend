package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.employee.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {

    void insert(Employee employee);

}
