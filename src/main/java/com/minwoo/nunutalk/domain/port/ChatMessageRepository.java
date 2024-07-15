package com.minwoo.nunutalk.domain.port;

import com.minwoo.nunutalk.domain.ChatMessage;

import java.util.UUID;

public interface ChatMessageRepository {
    ChatMessage findById(UUID id);

    ChatMessage save(ChatMessage chatMessage);
}
