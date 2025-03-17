package com.mycompany.courseerpbackend.services.teacher.schedule;

import com.mycompany.courseerpbackend.models.mappers.TeachersScheduleMapper;
import com.mycompany.courseerpbackend.models.mybatis.teacher.TeachersSchedule;
import com.mycompany.courseerpbackend.models.payload.teacher.schedule.TeacherSchedulePayload;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeachersScheduleBusinessServiceImpl implements TeachersScheduleBusinessService {

    final TeachersScheduleService teachersScheduleService;

    @Override
    public void addTeacherSchedule(TeacherSchedulePayload teacherSchedulePayload, Long teacherId) {
        Map<DayOfWeek, TeacherSchedulePayload.TeacherScheduleData> entries = teacherSchedulePayload.getEntries();
        Set<Map.Entry<DayOfWeek, TeacherSchedulePayload.TeacherScheduleData>> entrySet = entries.entrySet();
        for (Map.Entry<DayOfWeek, TeacherSchedulePayload.TeacherScheduleData> entry : entrySet) {
            // TODO: (IT) i can throw exception that dayOfWeek is not day of week
            DayOfWeek dayOfWeek = entry.getKey();
            TeacherSchedulePayload.TeacherScheduleData teacherScheduleData = entry.getValue();
            TeachersSchedule teachersSchedule = TeachersScheduleMapper.INSTANCE
                    .toEntity(teacherScheduleData, teacherId, dayOfWeek);

            // TODO: (IT) It should be great to fill all data to list and insert all in one query
            teachersScheduleService.insert(teachersSchedule);
        }
    }

//    @Override
//    public void upsertTeacherSchedule(TeacherSchedulePayload teacherSchedulePayload, Long teacherId) {
//        if (teacherId == null) teacherId = 1L;
//
//        List<TeachersSchedule> schedules = new ArrayList<>();
//
//        for (Map.Entry<java.time.DayOfWeek, TeacherSchedulePayload.TeacherScheduleData> entry
//                : teacherSchedulePayload.getEntries().entrySet()) {
//
//            java.time.DayOfWeek dayOfWeek = entry.getKey();
//            TeacherSchedulePayload.TeacherScheduleData scheduleData = entry.getValue();
//
//            TeachersSchedule teachersSchedule = TeachersSchedule.builder()
//                    .teacherId(teacherId)
//                    .branchId(scheduleData.getBranchId())
//                    .dayOfWeek(dayOfWeek)
//                    .startTime(scheduleData.getStartTime())
//                    .endTime(scheduleData.getEndTime())
//                    .isDeleted(false)
//                    .build();
//
//            schedules.add(teachersSchedule);
//        }
//
//        teachersScheduleService.upsert(schedules);
//
//    }

}
