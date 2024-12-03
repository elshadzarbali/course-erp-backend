package com.mycompany.courseerpbackend.controller;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import com.mycompany.courseerpbackend.models.dto.RefreshTokenDto;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.payload.auth.LoginPayload;
import com.mycompany.courseerpbackend.models.reponse.auth.LoginResponse;
import com.mycompany.courseerpbackend.services.security.AccessTokenManager;
import com.mycompany.courseerpbackend.services.security.RefreshTokenManager;
import com.mycompany.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccessTokenManager accessTokenManager;
    private final RefreshTokenManager refreshTokenManager;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload payload) {

        authenticate(payload);
        User user = userService.getByEmail(payload.getEmail());

        return BaseResponse.success(
                LoginResponse.builder()
                        .accessToken(accessTokenManager.generate(user))
                        .refreshToken(refreshTokenManager.generate(
                                RefreshTokenDto.builder()
                                        .user(user)
                                        .rememberMe(payload.isRememberMe())
                                        .build()
                        ))
                        .build()
        );
    }

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    private void authenticate(LoginPayload payload) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(payload.getEmail(), payload.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new RuntimeException("Exception");
        }
    }

}
