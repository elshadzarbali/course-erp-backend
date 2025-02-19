package com.mycompany.courseerpbackend.services.otp;

import java.util.UUID;

public class OtpServiceImpl implements OtpService {

    @Override
    public void send() {
        System.out.printf("OTP Send: %s%n", UUID.randomUUID().toString().substring(0, 4));
    }

}
