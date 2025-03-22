package com.mycompany.courseerpbackend.models.response.language;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanguageResponse {

    Long id;
    String name;
    String icon;

}
