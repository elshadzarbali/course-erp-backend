package com.mycompany.courseerpbackend.models.reponse.appconfig;

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
