package com.minwoo.nunutalk.common;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public record CustomResponse<T> (HttpStatus httpStatus, LocalDateTime timestamp, T body){

    public static <T> CustomResponse<T> of(HttpStatus httpStatus, T body) {
        return CustomResponse.<T>builder()
                .httpStatus(httpStatus)
                .body(body)
                .timestamp(LocalDateTime.now())
                .build();
    }
    public static <T> CustomResponse<T> create() {
        return CustomResponse.<T>builder()
                .httpStatus(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> CustomResponse<T> ok(T body) {
        return of(HttpStatus.OK, body);
    }
}
