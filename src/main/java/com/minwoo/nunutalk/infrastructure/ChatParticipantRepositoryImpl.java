package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatParticipant;
import com.minwoo.nunutalk.domain.port.ChatParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ChatParticipantRepositoryImpl implements ChatParticipantRepository {

    private final ChatParticipantJpaRepository jpaRepository;

    @Override
    public ChatParticipant findById(UUID id) {
        return jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find chatRoom with id: " + id));
    }

    @Override
    public ChatParticipant save(ChatParticipant chatParticipant) {
        return jpaRepository.save(chatParticipant);
    }

    @Override
    public List<ChatParticipant> findByMemberId(UUID memberId) {
        return jpaRepository.findByMemberId(memberId);
    }

    @Override
    public List<ChatParticipant> findByChatRoomId(UUID chatRoomId) {
        return jpaRepository.findByChatRoomId(chatRoomId);
    }
}
