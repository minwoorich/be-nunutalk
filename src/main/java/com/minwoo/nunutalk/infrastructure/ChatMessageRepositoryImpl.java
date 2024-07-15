package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.port.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ChatMessageRepositoryImpl implements ChatMessageRepository {

    private final ChatMessageJpaRepository jpaRepository;

    @Override
    public ChatMessage findById(UUID id) {
        return jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find chatMessage with id: " + id));
    }

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        return jpaRepository.save(chatMessage);
    }
}
