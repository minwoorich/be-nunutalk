package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.controller.CreateRoomDto;
import com.minwoo.nunutalk.domain.ChatParticipant;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.Member;
import com.minwoo.nunutalk.domain.enums.ChatRoomState;
import com.minwoo.nunutalk.domain.port.ChatParticipantRepository;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import com.minwoo.nunutalk.domain.port.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.minwoo.nunutalk.domain.enums.ChatRoomState.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatParticipantRepository chatParticipantRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ChatRoom create(CreateRoomDto createRoomDto) {

        ChatRoom chatRoom = chatRoomRepository.save(ChatRoom.builder().state(ACTIVE).title(createRoomDto.title()).build());

        Member owner = memberRepository.findById(createRoomDto.ownerId());
        Member friend = memberRepository.findById(createRoomDto.friendId());

        ChatParticipant chatParticipantOwner = ChatParticipant.builder().member(owner).chatRoom(chatRoom).build();
        ChatParticipant chatParticipantFriend = ChatParticipant.builder().member(friend).chatRoom(chatRoom).build();

        chatParticipantRepository.save(chatParticipantOwner);
        chatParticipantRepository.save(chatParticipantFriend);

        return chatRoom;
    }

}
