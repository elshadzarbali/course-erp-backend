package com.mycompany.courseerpbackend.models.mybatis.course;

import com.mycompany.courseerpbackend.models.enums.course.CourseStatus;
import com.mycompany.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
// SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity {

    String name;
    CourseStatus status;

}
