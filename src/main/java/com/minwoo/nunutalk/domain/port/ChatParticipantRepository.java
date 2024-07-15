package com.minwoo.nunutalk.domain.port;

import com.minwoo.nunutalk.domain.ChatParticipant;

import java.util.List;
import java.util.UUID;

public interface ChatParticipantRepository {
    ChatParticipant findById(UUID id);
    ChatParticipant save(ChatParticipant chatParticipant);
    List<ChatParticipant> findByMemberId(UUID memberId);
    List<ChatParticipant> findByChatRoomId(UUID memberId);
}
