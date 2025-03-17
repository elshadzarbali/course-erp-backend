package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.teacher.schedule.TeacherSchedulePayload;
import com.mycompany.courseerpbackend.services.teacher.schedule.TeachersScheduleBusinessService;
import com.mycompany.courseerpbackend.utils.RequestDataStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1/teachers/schedule")
@RequiredArgsConstructor
public class TeacherScheduleController {

    private final TeachersScheduleBusinessService teachersScheduleBusinessService;
    private final RequestDataStorage requestDataStorage;

    @PostMapping
    public BaseResponse<Void> addTeacherSchedule(@RequestBody TeacherSchedulePayload teacherSchedulePayload) {
        // TODO: (IT) Find teacherId by userId
        String teacherId = Objects.requireNonNullElse(requestDataStorage.getUserId(), "1");
        teachersScheduleBusinessService.addTeacherSchedule(teacherSchedulePayload, Long.valueOf(teacherId));

        // TODO: Investigate merge in SQL. it will help you to update/insert (depending on the existence of data)
        //  in one method. (88)
//        teachersScheduleBusinessService.upsertTeacherSchedule(teacherSchedulePayload, Long.parseLong(teacherId));
        return BaseResponse.created();
    }

}
