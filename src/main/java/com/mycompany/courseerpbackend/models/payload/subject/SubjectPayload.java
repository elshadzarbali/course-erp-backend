package com.mycompany.courseerpbackend.models.payload.subject;

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
