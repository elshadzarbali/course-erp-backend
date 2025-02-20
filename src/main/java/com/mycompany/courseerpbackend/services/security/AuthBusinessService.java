package com.mycompany.courseerpbackend.services.security;

import com.mycompany.courseerpbackend.models.payload.auth.LoginPayload;
import com.mycompany.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.mycompany.courseerpbackend.models.payload.auth.SignUpPayload;
import com.mycompany.courseerpbackend.models.payload.otp.BaseOTPChannelRequest;
import com.mycompany.courseerpbackend.models.payload.otp.BaseOTPRequest;
import com.mycompany.courseerpbackend.models.reponse.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    void signUp(SignUpPayload payload);

    void signUpOTP(BaseOTPChannelRequest payload);

    void signUpOTPConfirmation(BaseOTPRequest payload);

    void setAuthentication(String email);

}
