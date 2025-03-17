package com.mycompany.courseerpbackend.models.mybatis.teacher;

import com.mycompany.courseerpbackend.models.mybatis.base.IsDeletedEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeachersSchedule extends IsDeletedEntity {

    Long teacherId;
    Long branchId;
    DayOfWeek dayOfWeek;
    LocalDateTime startTime;
    LocalDateTime endTime;

}
