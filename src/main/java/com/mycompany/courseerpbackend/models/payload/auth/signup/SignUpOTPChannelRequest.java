package com.mycompany.courseerpbackend.models.payload.auth.signup;

import com.mycompany.courseerpbackend.models.common.proceedkey.ProceedKey;
import com.mycompany.courseerpbackend.models.enums.otp.OTPChannel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class SignUpOTPChannelRequest extends ProceedKey {

    OTPChannel channel;

}
