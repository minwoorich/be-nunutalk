package com.minwoo.nunutalk.common;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class CustomResponse<T> {
    private String uri;
    private int status;
    private String message;
    private T body;

}
