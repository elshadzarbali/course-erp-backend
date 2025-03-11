package com.mycompany.courseerpbackend.models.payload.user.settings;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersLanguagePayload {

    Long langId;

}
