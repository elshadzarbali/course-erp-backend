package com.mycompany.courseerpbackend.services.otp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SMSOTPServiceImpl implements OTPService {

    @Override
    public void send() {
        log.info("OTP send: {}", UUID.randomUUID());
    }
}
