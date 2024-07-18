package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatPariticipantJpaRepository extends JpaRepository<ChatParticipant, UUID> {

    List<ChatParticipant> findByMemberId(UUID memberId);
    List<ChatParticipant> findByChatRoomId(UUID memberId);
}
