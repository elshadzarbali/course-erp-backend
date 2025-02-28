package com.mycompany.courseerpbackend.models.payload.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentPayload {

    // TODO: validation
    String name;
    String surname;
    String email;
    String phoneNumber;

}
