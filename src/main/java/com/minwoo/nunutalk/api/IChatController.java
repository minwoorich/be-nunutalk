package com.minwoo.nunutalk.api;

import com.minwoo.nunutalk.api.dto.CreateRoomReq;
import com.minwoo.nunutalk.api.dto.MemberChatRoomsResp;
import com.minwoo.nunutalk.api.dto.SendMessageDto;
import com.minwoo.nunutalk.domain.ChatRoom;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "Chat", description = "채팅")
public interface IChatController {
    @Operation(summary = "채팅방 생성", description = "채팅방을 오픈할 때 호출하는 API")
//    @ApiResponse(responseCode = "200", description = "채팅방 생성에 성공하셨습니다", content = @Content(mediaType = "application/json"))
    @PostMapping("/chatrooms")
    ResponseEntity<ChatRoom> createChatRoom(@RequestBody CreateRoomReq createRoomReq);

    @GetMapping("/chatrooms/{memberId}")
    ResponseEntity<MemberChatRoomsResp> getChatRooms(@PathVariable(name = "memberId") UUID memberId);

    @MessageMapping("/messages")
    void send(Message<SendMessageDto> message);
}
