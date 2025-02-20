package com.mycompany.courseerpbackend.models.payload.otp;

import com.mycompany.courseerpbackend.models.enums.otp.OTPChannel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseOTPChannelRequest {

    OTPChannel channel;

}
