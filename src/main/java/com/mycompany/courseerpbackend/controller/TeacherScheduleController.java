package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.teacher.schedule.TeacherSchedulePayload;
import com.mycompany.courseerpbackend.services.teacher.schedule.TeachersScheduleBusinessService;
import com.mycompany.courseerpbackend.utils.RequestStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1/teachers/schedule")
@RequiredArgsConstructor
public class TeacherScheduleController {

    private final TeachersScheduleBusinessService teachersScheduleBusinessService;
    private final RequestStorage requestStorage;

    @PostMapping
    public BaseResponse<Void> addTeacherSchedule(@RequestBody TeacherSchedulePayload teacherSchedulePayload) {
        // TODO: (IT) Find teacherId by userId
        Long teacherId = Objects.requireNonNullElse(requestStorage.getUserId(), 1L);
        teachersScheduleBusinessService.addTeacherSchedule(teacherSchedulePayload, teacherId);

        // TODO: Investigate merge in SQL. it will help you to update/insert (depending on the existence of data)
        //  in one method. (88)
//        teachersScheduleBusinessService.upsertTeacherSchedule(teacherSchedulePayload, Long.parseLong(teacherId));
        return BaseResponse.created();
    }

}
