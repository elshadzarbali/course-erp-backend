package com.mycompany.courseerpbackend.services.security;

import com.mycompany.courseerpbackend.models.payload.auth.LoginPayload;
import com.mycompany.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.mycompany.courseerpbackend.models.payload.auth.SignUpPayload;
import com.mycompany.courseerpbackend.models.reponse.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    void signUp(SignUpPayload payload);

    void setAuthentication(String email);

}
