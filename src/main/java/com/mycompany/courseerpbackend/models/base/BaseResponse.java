package com.mycompany.courseerpbackend.models.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.exception.types.NotFoundExceptionType;
import com.mycompany.courseerpbackend.models.enums.response.ResponseMessages;
import com.mycompany.courseerpbackend.models.enums.response.SuccessResponseMessages;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.NOT_FOUND;
import static com.mycompany.courseerpbackend.models.enums.response.SuccessResponseMessages.CREATED;
import static com.mycompany.courseerpbackend.models.enums.response.SuccessResponseMessages.SUCCESS;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    HttpStatus status;
    Meta meta;
    T data;

    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder(access = AccessLevel.PRIVATE)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Meta {
        String key; // ex: not_found
        String message;

        public static Meta of(String key, String message) {
            return Meta.builder()
                    .key(key)
                    .message(message)
                    .build();
        }

        public static Meta of(ResponseMessages responseMessages) {
            return of(responseMessages.key(), responseMessages.message());
        }

        public static Meta of(BaseException ex) {
            if (ex.getResponseMessages().equals(NOT_FOUND)) {
                NotFoundExceptionType notFoundData = ex.getNotFoundData();
                return of(
                        String.format(ex.getResponseMessages().key(), notFoundData.getTarget().toLowerCase()),
                        String.format(
                                ex.getResponseMessages().message(),
                                notFoundData.getTarget(),
                                notFoundData.getFields().toString()
                        )
                );
            }

            return of(ex.getResponseMessages());
        }
    }

    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.OK)
                .meta(Meta.of(SUCCESS))
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> success() {
        return BaseResponse.success(null);
    }

    public static BaseResponse<?> error(BaseException ex) {
        return BaseResponse.builder()
                .meta(Meta.of(ex))
                .status(ex.getResponseMessages().status())
                .build();
    }

    public static <T> BaseResponse<T> created(T data) {
        return BaseResponse.<T>builder()
                .status(HttpStatus.CREATED)
                .meta(Meta.of(CREATED))
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> created() {
        return BaseResponse.created(null);
    }
}
