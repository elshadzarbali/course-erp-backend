package com.mycompany.courseerpbackend.exception;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // extends ResponseEntityExceptionHandler

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<?>> handleBaseException(BaseException ex) {
        return ResponseEntity.status(ex.getResponseMessages().status()).body(BaseResponse.error(ex));
    }

//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<BaseResponse<?>> handleUsernameNotFoundException(UsernameNotFoundException ex) {
//        BaseException baseException = (BaseException) ex.getCause();
//        return ResponseEntity.status(baseException.getResponseMessages().status()).body(BaseResponse.error(baseException));
//    }

}
