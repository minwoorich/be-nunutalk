package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.api.dto.CreateRoomDto;
import com.minwoo.nunutalk.domain.ChatParticipant;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.Member;
import com.minwoo.nunutalk.domain.port.ChatParticipantRepository;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import com.minwoo.nunutalk.domain.port.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.minwoo.nunutalk.domain.enums.ChatRoomState.ACTIVE;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatParticipantRepository chatParticipantRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ChatRoom create(CreateRoomDto createRoomDto) {

        // 채팅방 엔티티 생성 및 저장
        ChatRoom chatRoom = chatRoomRepository.save(ChatRoom.create(createRoomDto.title(), ACTIVE));

        // 채팅방에 참가한 모든 인원들 엔티티 생성 및 저장
        List<Member> members = memberRepository.findAllIn(createRoomDto.memberIds());

        // ChatParticipant (연결 테이블) 생성 및 저장
        members.stream()
                .map(member -> ChatParticipant.create(chatRoom, member))
                .forEach(chatParticipantRepository::save);

        return chatRoom;
    }

}
