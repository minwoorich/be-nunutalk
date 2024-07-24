package com.minwoo.nunutalk.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
class CustomResponseTest {

    @Test
    @DisplayName("HttpStatus httpStatus, T body 를 통해 CustomResponse 객체를 생성할 수 있다")
    void of() {
        // given
        String body = "응답바디";
        HttpStatus httpStatus = HttpStatus.OK;

        // when
        CustomResponse<String> response = CustomResponse.of(httpStatus, body);

        // then
        assertThat(response)
                .extracting("httpStatus", "body")
                .contains(httpStatus, body);
    }

    @Test
    @DisplayName("body 만 넣으면 알아서 OK http상태코드를 포함한 CustomReponse 가 생성된다")
    void ok() {
        // given
        String body = "응답바디";

        // when
        CustomResponse<String> response = CustomResponse.ok(body);

        // then
        assertThat(response)
                .extracting("httpStatus", "body")
                .contains(HttpStatus.OK, body);
    }
}