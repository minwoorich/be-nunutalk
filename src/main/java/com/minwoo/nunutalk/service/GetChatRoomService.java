package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.domain.ChatParticipant;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.port.ChatParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetChatRoomService {
    private final ChatParticipantRepository chatParticipantRepository;

    public List<ChatRoom> findAllChatRooms(UUID memberId){
        return chatParticipantRepository
                .findByMemberId(memberId).stream()
                .map(ChatParticipant::getChatRoom)
                .toList();
    }
}
