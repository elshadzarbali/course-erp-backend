package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.common.proceedkey.ProceedKey;
import com.mycompany.courseerpbackend.models.payload.auth.LoginPayload;
import com.mycompany.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpPayload;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpOTPChannelRequest;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpOTPRequest;
import com.mycompany.courseerpbackend.models.reponse.auth.LoginResponse;
import com.mycompany.courseerpbackend.services.security.AuthBusinessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@Valid @RequestBody LoginPayload payload) {
        return BaseResponse.success(authBusinessService.login(payload));
    }

    @PostMapping("/token/refresh")
    public BaseResponse<LoginResponse> refresh(@RequestBody RefreshTokenPayload payload) {
        return BaseResponse.success(authBusinessService.refresh(payload));
    }

    @PostMapping("/logout")
    public BaseResponse<Void> logout() {
        authBusinessService.logout();
        return BaseResponse.success();
    }

    @PostMapping("/sign-up")
    public BaseResponse<ProceedKey> signUp(@RequestBody SignUpPayload payload) {
        return BaseResponse.success(authBusinessService.signUp(payload));
    }

    @PostMapping("/sign-up/otp/request")
    public BaseResponse<Void> otpRequest(@RequestBody SignUpOTPChannelRequest payload) {
        authBusinessService.signUpOTP(payload);
        return BaseResponse.success();
    }

    @PostMapping("/sign-up/otp/confirmation")
    public BaseResponse<Void> otpConfirmation(@RequestBody SignUpOTPRequest payload) {
        authBusinessService.signUpOTPConfirmation(payload);
        return BaseResponse.success();
    }

}
