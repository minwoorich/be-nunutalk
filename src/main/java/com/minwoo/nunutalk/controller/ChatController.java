package com.minwoo.nunutalk.controller;

import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;
    private final ChatService chatService;

    @PostMapping("/chatroom")
    public void createRoom(@RequestBody CreateRoomDto createRoomDto){

    }
    @SubscribeMapping("/message")
    public void join(Message<SubsMessageDto> message) {

    }
    @MessageMapping("/message")
    public void send(Message<SendMessageDto> message) {
        template.convertAndSend("/chat-room",message.getPayload());
        ChatMessage savedMessage = chatService.saveMessage(message.getPayload());
        log.info("savedMessage:{}",savedMessage);
    }
}
