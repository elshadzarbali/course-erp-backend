package com.mycompany.courseerpbackend.models.payload.auth;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginPayload {

    // TODO: (IT) My message can be message code which stores in database

    @Email(message = "Email is not valid format")
    @NotBlank(message = "Email can not be empty")
    @Size(min = 5, max = 254, message = "Email should be between 5 and 254 characters")
    String email;

    @NotBlank(message = "Password can not be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    String password;

    boolean rememberMe;

}
