package com.mycompany.courseerpbackend.models.payload.language;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanguagePayload {

    // TODO: validation
    String name;
    String icon;

}
