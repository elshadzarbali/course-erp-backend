package com.mycompany.courseerpbackend.services.otp;

import com.mycompany.courseerpbackend.models.dto.SendOTPDto;

// todo: Factory Pattern
public interface OTPService {

    void send(SendOTPDto dto);

}
