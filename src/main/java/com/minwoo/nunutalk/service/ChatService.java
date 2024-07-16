package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.controller.SendMessageDto;
import com.minwoo.nunutalk.controller.SubsMessageDto;
import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.port.ChatMessageRepository;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public ChatMessage findById(UUID id) {
        return chatMessageRepository.findById(id);
    }

    public ChatRoom createRoom(SubsMessageDto message) {

    }

    public ChatMessage saveMessage(SendMessageDto message) {
        ChatMessage messageEntity = message.toEntity();
        log.info("save chat message: {}", messageEntity);
        return chatMessageRepository.save(messageEntity);
    }
}
