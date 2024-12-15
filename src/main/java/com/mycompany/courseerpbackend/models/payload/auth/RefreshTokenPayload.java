package com.mycompany.courseerpbackend.models.payload.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenPayload {

    String refreshToken;
    boolean rememberMe;

}
