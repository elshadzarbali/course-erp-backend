package com.mycompany.courseerpbackend.models.mybatis.language;

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
public class Language extends BaseEntity<Long> {

    String name;
    Boolean hasLocalization;
    String icon;
    Boolean isDefault;

}
