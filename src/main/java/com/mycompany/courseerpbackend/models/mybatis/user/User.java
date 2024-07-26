package com.mycompany.courseerpbackend.models.mybatis.user;

import com.mycompany.courseerpbackend.models.enums.user.UserStatus;
import com.mycompany.courseerpbackend.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
// SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    String name;
    String surname;
    UserStatus status;
    Long roleId;
    String email;
    String phoneNumber;
    String password;

}
