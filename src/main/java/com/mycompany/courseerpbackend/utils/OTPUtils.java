package com.mycompany.courseerpbackend.utils;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.services.redis.RedisService;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.OTP_IS_NOT_VALID;

@Component
public class OTPUtils {

    private static RedisService redisService;

    public OTPUtils(RedisService redisService) {
        OTPUtils.redisService = redisService;
    }

    public static String generate() {
        Random rand = new Random();
        return String.format("%04d", rand.nextInt(10000));
    }

    public static void isValid(String key, String otp) {
        String otpValue = redisService.get(key);
        if (otpValue == null || !otpValue.equals(otp))
            throw BaseException.of(OTP_IS_NOT_VALID);
    }

}
