package com.mycompany.courseerpbackend.models.enums.otp;

import com.mycompany.courseerpbackend.exception.ExceptionBuilder;
import com.mycompany.courseerpbackend.models.mybatis.user.User;

public enum OTPChannel {

    SMS, EMAIL;

    public String getTarget(User user) {
        if (this.equals(SMS)) {
            return user.getPhoneNumber();
        } else if (this.equals(EMAIL)) {
            return user.getEmail();
        } else {
            throw ExceptionBuilder.unexpected();
        }
    }

}
