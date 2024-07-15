package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ChatRoomRepositoryImpl implements ChatRoomRepository {

    private final ChatRoomJpaRepository jpaRepository;

    @Override
    public ChatRoom save(ChatRoom chatRoom) {
        return jpaRepository.save(chatRoom);
    }

    @Override
    public ChatRoom findById(UUID id) {
        return jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find chatRoom with id: " + id));
    }
}
