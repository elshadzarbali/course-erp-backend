package com.mycompany.courseerpbackend.models.payload.teacher;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherPayload {

    String name;
    String surname;
    String email;
    String phoneNumber;

}
