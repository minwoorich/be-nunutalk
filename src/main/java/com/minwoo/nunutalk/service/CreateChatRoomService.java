package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.controller.CreateRoomDto;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.port.ChatParticipantRepository;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatParticipantRepository chatParticipantRepository;

    // TODO
    public ChatRoom create(CreateRoomDto createRoomDto) {
        return null;
    }

}
