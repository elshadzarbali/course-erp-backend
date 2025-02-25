package com.mycompany.courseerpbackend.services.group;

import com.mycompany.courseerpbackend.models.mybatis.group.Group;

import java.util.List;

public interface GroupService {

    void insert(Group group);

    void update(Group group);

    Group findById(Long id);

    List<Group> findAll();

}
