package com.mycompany.courseerpbackend.models.payload.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpPayload {

    String name;
    String surname;
    String email;
    String phoneNumber;
    String password;

    String courseName;
    String address;

}
