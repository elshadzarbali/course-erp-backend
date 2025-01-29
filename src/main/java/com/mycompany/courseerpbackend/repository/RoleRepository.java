package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface RoleRepository {

    Optional<Role> findByName(@Param("name") String name);

}
