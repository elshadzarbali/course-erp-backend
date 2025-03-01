package com.mycompany.courseerpbackend.models.mybatis.branch;

import com.mycompany.courseerpbackend.models.enums.branch.BranchStatus;
import com.mycompany.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch extends BaseEntity<Long> {

    String name;
    BranchStatus status;
    String address;
    Double lat;
    Double lon;
    Long courseId;

}
