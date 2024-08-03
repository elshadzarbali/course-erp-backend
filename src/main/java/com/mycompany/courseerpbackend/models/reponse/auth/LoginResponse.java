package com.mycompany.courseerpbackend.models.reponse.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {

    String accessToken;
    String refreshToken;
    UserInfo userInfo;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class UserInfo {

        Long id;
        String name;
        String surname;
        String imageUrl;

    }

}
