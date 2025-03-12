package com.mycompany.courseerpbackend.services.otp;

import com.mycompany.courseerpbackend.models.dto.SendOTPDto;
import com.mycompany.courseerpbackend.services.redis.RedisService;
import com.mycompany.courseerpbackend.helpers.OTPHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailOTPServiceImpl implements OTPService {

    private final RedisService redisService;
    private final OTPHelper otpHelper;

    @Override
    public void send(SendOTPDto dto) {
        final String otp = otpHelper.generate();

        redisService.set(dto.getKey(), otp, 5);

        log.info("OTP send via Email to: {}, OTP: {}", dto.getTarget(), otp);
    }
}
