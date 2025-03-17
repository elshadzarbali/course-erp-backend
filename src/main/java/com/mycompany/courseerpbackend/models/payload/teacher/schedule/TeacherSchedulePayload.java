package com.mycompany.courseerpbackend.models.payload.teacher.schedule;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherSchedulePayload {

    Map<DayOfWeek, TeacherScheduleData> entries;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class TeacherScheduleData {

        Long branchId;
        LocalDateTime startTime;
        LocalDateTime endTime;

    }

}
