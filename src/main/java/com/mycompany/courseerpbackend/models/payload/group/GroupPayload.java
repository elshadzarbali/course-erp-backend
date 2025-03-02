package com.mycompany.courseerpbackend.models.payload.group;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupPayload {

    // TODO: validation
    String name;

}
