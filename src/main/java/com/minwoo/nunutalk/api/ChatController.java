package com.minwoo.nunutalk.api;

import com.minwoo.nunutalk.common.annotations.ApiV1Controller;
import com.minwoo.nunutalk.api.dto.CreateRoomDto;
import com.minwoo.nunutalk.api.dto.MemberChatRoomsResp;
import com.minwoo.nunutalk.api.dto.SendMessageDto;
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

    @PostMapping("/ChatRooms")
    public ResponseEntity<ChatRoom> createChatRoom(@RequestBody CreateRoomDto createRoomDto){
        return ResponseEntity.ok(createChatRoomService.create(createRoomDto));
    }

    @GetMapping("/ChatRooms/{memberId}")
    public ResponseEntity<MemberChatRoomsResp> getChatRooms(@PathVariable(name = "memberId") UUID memberId){
        return ResponseEntity.ok(MemberChatRoomsResp.create(memberId, getChatRoomInfos(memberId)));
    }

    private List<MemberChatRoomsResp.ChatRoomInfo> getChatRoomInfos(UUID memberId) {
        return getChatRoomService
                .findAllChatRooms(memberId).stream()
                .map(MemberChatRoomsResp.ChatRoomInfo::from)
                .toList();
    }

    @MessageMapping("/messages")
    public void send(Message<SendMessageDto> message) {
        template.convertAndSend("/chat-room",message.getPayload());
        ChatMessage savedMessage = chatService.saveMessage(message.getPayload());
        log.info("savedMessage:{}",savedMessage);
    }

}
