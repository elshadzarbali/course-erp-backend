package com.mycompany.courseerpbackend.models.payload.country;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryPayload {

    // TODO: validation
    String name;

}
