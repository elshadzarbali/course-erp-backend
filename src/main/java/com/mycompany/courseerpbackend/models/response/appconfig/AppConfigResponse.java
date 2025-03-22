package com.mycompany.courseerpbackend.models.response.appconfig;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfigResponse {

    String value;
    String description;

}
