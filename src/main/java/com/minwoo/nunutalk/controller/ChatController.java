package com.minwoo.nunutalk.controller;

import com.minwoo.nunutalk.annotations.ApiV1Controller;
import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.service.ChatService;
import com.minwoo.nunutalk.service.CreateChatRoomService;
import com.minwoo.nunutalk.service.GetChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@ApiV1Controller
public class ChatController {

    private final SimpMessagingTemplate template;
    private final ChatService chatService;
    private final CreateChatRoomService createChatRoomService;
    private final GetChatRoomService getChatRoomService;

    @PostMapping("/chatrooms")
    public ResponseEntity<ChatRoom> createRoom(@RequestBody CreateRoomDto createRoomDto){
        return ResponseEntity.ok(createChatRoomService.create(createRoomDto));
    }

    @GetMapping("/chatrooms/{memberId}")
    public ResponseEntity<List<ChatRoom>> getChatRooms(@PathVariable(name = "memberId") UUID memberId){
        return ResponseEntity.ok(getChatRoomService.findAllChatRooms(memberId));
    }

    @MessageMapping("/messages")
    public void send(Message<SendMessageDto> message) {
        template.convertAndSend("/chat-room",message.getPayload());
        ChatMessage savedMessage = chatService.saveMessage(message.getPayload());
        log.info("savedMessage:{}",savedMessage);
    }

    // TODO
    static record GetChatRoomDto(String roomId, String memberId) {}

}
