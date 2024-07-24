package com.minwoo.nunutalk.api;

import com.minwoo.nunutalk.api.dto.CreateRoomReq;
import com.minwoo.nunutalk.api.dto.MemberChatRoomsResp;
import com.minwoo.nunutalk.api.dto.SendMessageDto;
import com.minwoo.nunutalk.common.CustomResponse;
import com.minwoo.nunutalk.common.annotations.ApiV1Controller;
import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.service.ChatService;
import com.minwoo.nunutalk.service.CreateChatRoomService;
import com.minwoo.nunutalk.service.GetChatRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;
import java.util.UUID;

@Slf4j
@ApiV1Controller
public class ChatController implements IChatController{

    private final SimpMessagingTemplate template;
    private final ChatService chatService;
    private final CreateChatRoomService createChatRoomService;
    private final GetChatRoomService getChatRoomService;

    public ChatController(SimpMessagingTemplate template, ChatService chatService, CreateChatRoomService createChatRoomService, GetChatRoomService getChatRoomService) {
        this.template = template;
        this.chatService = chatService;
        this.createChatRoomService = createChatRoomService;
        this.getChatRoomService = getChatRoomService;
    }

    @Override
    public CustomResponse<?> createChatRoom(CreateRoomReq createRoomReq){
        createChatRoomService.create(createRoomReq);
        return CustomResponse.create();
    }

    @Override
    public CustomResponse<MemberChatRoomsResp> getChatRooms(UUID memberId){
        return CustomResponse.ok(MemberChatRoomsResp.create(memberId, getChatRoomInfos(memberId)));
    }

    private List<MemberChatRoomsResp.ChatRoomInfo> getChatRoomInfos(UUID memberId) {
        return getChatRoomService
                .findAllChatRooms(memberId).stream()
                .map(MemberChatRoomsResp.ChatRoomInfo::from)
                .toList();
    }

    @Override
    public void send(Message<SendMessageDto> message) {
        template.convertAndSend("/chat-room",message.getPayload());
        ChatMessage savedMessage = chatService.saveMessage(message.getPayload());
        log.info("savedMessage:{}",savedMessage);
    }

}
