package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.payload.teacher.schedule.TeacherSchedulePayload;
import com.mycompany.courseerpbackend.services.teacher.schedule.TeachersScheduleBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/teachers/schedule")
@RequiredArgsConstructor
public class TeacherScheduleController {

    private final TeachersScheduleBusinessService teachersScheduleBusinessService;

    @PostMapping
    public BaseResponse<Void> addTeacherSchedule(@RequestBody TeacherSchedulePayload teacherSchedulePayload) {
        teachersScheduleBusinessService.addTeacherSchedule(teacherSchedulePayload);

        // TODO: Investigate merge in SQL. it will help you to update/insert (depending on the existence of data)
        //  in one method. (88)
//        teachersScheduleBusinessService.upsertTeacherSchedule(teacherSchedulePayload, Long.parseLong(teacherId));
        return BaseResponse.created();
    }

}
