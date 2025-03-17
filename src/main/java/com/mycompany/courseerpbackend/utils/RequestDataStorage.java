package com.mycompany.courseerpbackend.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Component
@RequestScope
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestDataStorage {

    // TODO: (IT) They should be Long type
    String userId;
    String userLanguage;

}
