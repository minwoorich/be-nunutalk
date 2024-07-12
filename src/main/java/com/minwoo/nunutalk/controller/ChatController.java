package com.minwoo.nunutalk.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private static final String GREETING_MESSAGE = "채팅방에 입장하신것을 환영합니다";

    @SubscribeMapping("/topic/{roomNo}")
    public String join(@DestinationVariable String roomNo) {
        return GREETING_MESSAGE;
    }
}
