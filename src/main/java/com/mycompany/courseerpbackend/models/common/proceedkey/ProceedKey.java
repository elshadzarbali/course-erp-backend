package com.mycompany.courseerpbackend.models.common.proceedkey;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProceedKey {

    // I think, its name should be proceedKeyToken or something like this
    String proceedKey;

}
