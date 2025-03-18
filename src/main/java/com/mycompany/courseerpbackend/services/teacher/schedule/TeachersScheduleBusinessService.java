package com.mycompany.courseerpbackend.services.teacher.schedule;

import com.mycompany.courseerpbackend.models.payload.teacher.schedule.TeacherSchedulePayload;

public interface TeachersScheduleBusinessService {

    void addTeacherSchedule(TeacherSchedulePayload teacherSchedulePayload);

//    void upsertTeacherSchedule(TeacherSchedulePayload teacherSchedulePayload, Long teacherId);

}
