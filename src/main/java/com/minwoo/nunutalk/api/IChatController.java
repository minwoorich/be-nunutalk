package com.minwoo.nunutalk.api;

import com.minwoo.nunutalk.api.dto.CreateRoomReq;
import com.minwoo.nunutalk.api.dto.MemberChatRoomsResp;
import com.minwoo.nunutalk.api.dto.SendMessageDto;
import com.minwoo.nunutalk.common.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @PostMapping("/chatrooms")
    CustomResponse<?> createChatRoom(@RequestBody CreateRoomReq createRoomReq);

    @Operation(summary = "채팅방 불러오기", description = "회원이 참가해있는 모든 채팅방 정보를 불러온다")
    @Parameter(name = "memberId", example = "0190d945-4424-7bee-af99-3a83d52985cb")
    @GetMapping("/chatrooms/{memberId}")
    CustomResponse<MemberChatRoomsResp> getChatRooms(@PathVariable(name = "memberId") UUID memberId);

    @MessageMapping("/messages")
    void send(Message<SendMessageDto> message);
}
