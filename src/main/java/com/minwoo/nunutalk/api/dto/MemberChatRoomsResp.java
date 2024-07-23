package com.minwoo.nunutalk.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.enums.ChatRoomState;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

// TODO : filter 파라미터
@Builder
public record MemberChatRoomsResp(UUID memberId, List<ChatRoomInfo> ChatRoomInfos) {
    @Builder
    public record ChatRoomInfo(UUID roomId, ChatRoomState state, String title, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdAt){
        public static ChatRoomInfo from(ChatRoom ChatRoom){
            return ChatRoomInfo.builder()
                    .roomId(ChatRoom.getId())
                    .state(ChatRoom.getState())
                    .title(ChatRoom.getTitle())
                    .createdAt(ChatRoom.getCreatedAt())
                    .build();
        }
    }

    public static MemberChatRoomsResp create(UUID memberId, List<ChatRoomInfo> ChatRoomInfos) {
        return MemberChatRoomsResp.builder().memberId(memberId).ChatRoomInfos(ChatRoomInfos).build();
    }
}
