package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.port.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatRepositoryImpl implements ChatRepository {

    private final ChatJpaRepository jpaRepository;

    @Override
    public ChatMessage findById(Long id) {
        return jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find chat with id: " + id));
    }

    @Override
    public void save(ChatMessage chatMessage) {
        jpaRepository.save(chatMessage);
    }
}
