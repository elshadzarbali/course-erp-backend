package com.mycompany.courseerpbackend.models.mybatis.subject;

import com.mycompany.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject extends BaseEntity<Long> {

    String name;
    Long courseId;
    Long languageId;

}
