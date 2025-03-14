package com.mycompany.courseerpbackend.exception;

import com.mycompany.courseerpbackend.exception.types.NotFoundExceptionType;
import com.mycompany.courseerpbackend.models.enums.response.ResponseMessages;

import java.util.Map;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.UNEXPECTED;

public class ExceptionBuilder {

    public static BaseException of(ResponseMessages responseMessages) {
        return BaseException.builder().responseMessages(responseMessages).build();
    }

    public static BaseException unexpected() {
        return of(UNEXPECTED);
    }

    public static BaseException notFound(String target, String field, Object value) {
        return BaseException.builder()
                .responseMessages(NOT_FOUND)
                .notFoundData(
                        NotFoundExceptionType.of(target, Map.of(field, value))
                )
                .build();
    }

}
