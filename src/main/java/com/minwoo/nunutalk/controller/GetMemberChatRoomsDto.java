package com.minwoo.nunutalk.controller;

import com.minwoo.nunutalk.domain.enums.ChatRoomState;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public record GetMemberChatRoomsDto(UUID memberId, String name, String email, List<ChatRoomInfo> chatRoomInfos) {
    public record ChatRoomInfo(UUID roomId, ChatRoomState state, String title, ZonedDateTime createdAt){}
}
