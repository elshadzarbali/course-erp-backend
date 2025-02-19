package com.mycompany.courseerpbackend.models.mybatis.employee;

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
public class Employee extends BaseEntity {

    Long userId;

}
