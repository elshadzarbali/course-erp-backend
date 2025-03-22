package com.mycompany.courseerpbackend.services.security;

import com.mycompany.courseerpbackend.models.common.proceedkey.ProceedKey;
import com.mycompany.courseerpbackend.models.payload.auth.LoginPayload;
import com.mycompany.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpPayload;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpOTPChannelRequest;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpOTPRequest;
import com.mycompany.courseerpbackend.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    ProceedKey signUp(SignUpPayload payload);

    void signUpOTP(SignUpOTPChannelRequest payload);

    void signUpOTPConfirmation(SignUpOTPRequest payload);

    void setAuthentication(String email);

}
