package com.minwoo.nunutalk.controller;

import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.enums.ChatRoomState;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

// TODO : filter 파라미터
@Builder
public record MemberChatRoomsResp(UUID memberId, List<ChatRoomInfo> chatRoomInfos) {
    @Builder
    public record ChatRoomInfo(UUID roomId, ChatRoomState state, String title, ZonedDateTime createdAt){
        public static ChatRoomInfo from(ChatRoom chatRoom){
            return ChatRoomInfo.builder()
                    .roomId(chatRoom.getId())
                    .state(chatRoom.getState())
                    .title(chatRoom.getTitle())
                    .createdAt(chatRoom.getCreatedAt())
                    .build();
        }
    }
}
