package com.minwoo.nunutalk.controller.dto;

import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.Member;
import com.minwoo.nunutalk.domain.enums.MessageType;

import java.util.UUID;

public record SendMessageDto(UUID roomId, UUID senderId, String msg, MessageType type) {
    public ChatMessage toEntity(){
        ChatRoom chatRoom = ChatRoom.builder().id(roomId).build();
        Member sender = Member.builder().id(senderId).build();

        return ChatMessage.builder()
                .chatRoom(chatRoom)
                .sender(sender)
                .messageType(type)
                .msg(msg)
                .build();
    }
}
