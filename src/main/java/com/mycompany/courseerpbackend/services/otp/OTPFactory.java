package com.mycompany.courseerpbackend.services.otp;

import com.mycompany.courseerpbackend.models.enums.otp.OTPChannel;
import org.springframework.stereotype.Service;

@Service
public class OTPFactory {

    private static EmailOTPServiceImpl emailChannel;
    private static SMSOTPServiceImpl smsChannel;

    public OTPFactory(EmailOTPServiceImpl emailChannel, SMSOTPServiceImpl smsChannel) {
        OTPFactory.emailChannel = emailChannel;
        OTPFactory.smsChannel = smsChannel;
    }

    public static OTPService handle(OTPChannel channel) {
        return switch (channel) {
            case SMS -> smsChannel;
            case EMAIL -> emailChannel;
        };
    }

}
