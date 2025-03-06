package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.student.StudentPayload;
import com.mycompany.courseerpbackend.services.student.StudentBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentBusinessService studentBusinessService;

    @PostMapping
    public BaseResponse<Void> addStudent(@RequestBody StudentPayload studentPayload) {
        studentBusinessService.addStudent(studentPayload);
        return BaseResponse.success();
    }

    @PostMapping("/{id}/groups/{groupId}")
    public BaseResponse<Void> addStudentToGroup(@PathVariable("id") Long id, @PathVariable("groupId") Long groupId) {
        studentBusinessService.addStudentToGroup(id, groupId);
        return BaseResponse.success();
    }

}
