package com.mycompany.courseerpbackend.models.payload;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectPayload {

    // TODO: validation
    String name;
    Long languageId;

}
