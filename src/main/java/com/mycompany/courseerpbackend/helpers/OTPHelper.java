package com.mycompany.courseerpbackend.helpers;

import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import com.mycompany.courseerpbackend.services.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.OTP_IS_NOT_VALID;

@Component
@RequiredArgsConstructor
public class OTPHelper {

    private final RedisService redisService;

    public String generate() {
        Random rand = new Random();
        return String.format("%04d", rand.nextInt(10000));
    }

    public void isValid(String key, String otp) {
        String otpValue = redisService.get(key);
        if (otpValue == null || !otpValue.equals(otp))
            throw ExceptionBuilder.of(OTP_IS_NOT_VALID);
    }

}
