package com.mycompany.courseerpbackend.repository;

import com.mycompany.courseerpbackend.models.mybatis.group.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GroupRepository {

    void insert(Group group);

    void update(Group group);

    Optional<Group> findById(@Param("id") Long id);

    List<Group> findAll();

}
