package com.minwoo.nunutalk.domain.port;

import com.minwoo.nunutalk.domain.ChatMessage;

public interface ChatRepository {
    ChatMessage findById(Long id);

    void save(ChatMessage chatMessage);
}
