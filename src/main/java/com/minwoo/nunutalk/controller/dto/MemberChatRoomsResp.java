package com.minwoo.nunutalk.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    public record ChatRoomInfo(UUID roomId, ChatRoomState state, String title, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") ZonedDateTime createdAt){
        public static ChatRoomInfo from(ChatRoom chatRoom){
            return ChatRoomInfo.builder()
                    .roomId(chatRoom.getId())
                    .state(chatRoom.getState())
                    .title(chatRoom.getTitle())
                    .createdAt(chatRoom.getCreatedAt())
                    .build();
        }
    }

    public static MemberChatRoomsResp create(UUID memberId, List<ChatRoomInfo> chatRoomInfos) {
        return MemberChatRoomsResp.builder().memberId(memberId).chatRoomInfos(chatRoomInfos).build();
    }
}
