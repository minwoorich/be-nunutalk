package com.minwoo.nunutalk.domain.port;

import com.minwoo.nunutalk.domain.ChatRoom;

import java.util.UUID;

public interface ChatRoomRepository {
    ChatRoom save(ChatRoom chatRoom);
    ChatRoom findById(UUID id);
}
