package com.mycompany.courseerpbackend.exception;

import com.mycompany.courseerpbackend.models.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        return ResponseEntity.status(
//                baseException.getResponseMessages().status()).body(BaseResponse.error(baseException)
//        );
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<?>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Map<String, Object>> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(
                error -> {
                    errors.computeIfAbsent(error.getField(), k -> new HashMap<>())
                            .computeIfAbsent("messages", k -> new ArrayList<String>());

                    ((List<String>) errors.get(error.getField()).get("messages")).add(error.getDefaultMessage());
                    errors.get(error.getField()).put("rejectedValue", error.getRejectedValue());
                }
        );

        return ResponseEntity.badRequest().body(BaseResponse.validationFailed(errors));
    }

}
