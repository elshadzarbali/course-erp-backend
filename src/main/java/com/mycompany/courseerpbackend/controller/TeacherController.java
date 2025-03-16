package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.teacher.TeacherPayload;
import com.mycompany.courseerpbackend.services.teacher.TeacherBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherBusinessService teacherBusinessService;

    @PostMapping
    public BaseResponse<Void> createTeacher(@RequestBody TeacherPayload teacherPayload) {
        teacherBusinessService.insert(teacherPayload);
        return BaseResponse.created();
    }

}
