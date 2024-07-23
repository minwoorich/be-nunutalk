package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.controller.dto.SendMessageDto;
import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.port.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(SendMessageDto message) {
        ChatMessage messageEntity = message.toEntity();
        log.info("save chat message: {}", messageEntity);
        return chatMessageRepository.save(messageEntity);
    }
}
