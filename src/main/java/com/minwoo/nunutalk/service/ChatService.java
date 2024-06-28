package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.port.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatMessage findById(Long id) {
        return chatRepository.findById(id);
    }
}
