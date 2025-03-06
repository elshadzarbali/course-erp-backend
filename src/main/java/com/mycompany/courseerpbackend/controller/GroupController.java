package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.mappers.GroupEntityMapper;
import com.mycompany.courseerpbackend.models.payload.group.GroupPayload;
import com.mycompany.courseerpbackend.services.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public BaseResponse<Void> addGroup(@RequestBody GroupPayload groupPayload) {
        groupService.insert(
                GroupEntityMapper.INSTANCE.toEntity(groupPayload)
        );
        return BaseResponse.created();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateGroup(@PathVariable("id") Long id, @RequestBody GroupPayload groupPayload) {
        groupService.update(
                GroupEntityMapper.INSTANCE.toEntity(groupPayload, id)
        );
        return BaseResponse.success();
    }

}
