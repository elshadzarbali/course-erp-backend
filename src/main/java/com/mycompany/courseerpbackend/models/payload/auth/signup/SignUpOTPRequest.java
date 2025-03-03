package com.mycompany.courseerpbackend.models.payload.auth.signup;

import com.mycompany.courseerpbackend.models.common.proceedkey.ProceedKey;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class SignUpOTPRequest extends ProceedKey {

    String otp;

}
