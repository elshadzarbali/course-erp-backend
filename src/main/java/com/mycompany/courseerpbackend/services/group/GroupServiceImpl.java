package com.mycompany.courseerpbackend.services.group;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.mybatis.group.Group;
import com.mycompany.courseerpbackend.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public void insert(Group group) {
        groupRepository.insert(group);
    }

    @Override
    public void update(Group group) {
        groupRepository.update(group);
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Group.class.getSimpleName(), "id", String.valueOf(id))
        );
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

}
