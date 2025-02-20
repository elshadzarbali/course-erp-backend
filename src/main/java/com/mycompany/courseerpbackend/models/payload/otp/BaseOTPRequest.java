package com.mycompany.courseerpbackend.models.payload.otp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseOTPRequest {

    String otp;

}
