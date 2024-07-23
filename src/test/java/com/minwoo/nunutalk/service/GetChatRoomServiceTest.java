package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.domain.ChatParticipant;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.Member;
import com.minwoo.nunutalk.domain.enums.ChatRoomState;
import com.minwoo.nunutalk.domain.port.ChatParticipantRepository;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import com.minwoo.nunutalk.domain.port.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
@Transactional
class GetChatRoomServiceTest {

    @Autowired GetChatRoomService getChatRoomService;
    @Autowired MemberRepository memberRepository;
    @Autowired ChatParticipantRepository chatParticipantRepository;
    @Autowired ChatRoomRepository ChatRoomRepository;

    @Test
    @DisplayName("특정 회원이 참가해있는 모든 채팅방을 조회할 수 있다")
    void findAllChatRooms() {
        // given
        Member member1 = memberRepository.save(Member.builder().memberName("홍길동").build());
        Member member2 = memberRepository.save(Member.builder().memberName("정길동").build());
        Member member3 = memberRepository.save(Member.builder().memberName("박길동").build());
        Member member4 = memberRepository.save(Member.builder().memberName("최길동").build());

        ChatRoom ChatRoom1 = ChatRoomRepository.save(ChatRoom.builder().title("독서 스터디").state(ChatRoomState.ACTIVE).build());
        ChatRoom ChatRoom2 = ChatRoomRepository.save(ChatRoom.builder().title("코딩 스터디").state(ChatRoomState.ACTIVE).build());
        ChatRoom ChatRoom3 = ChatRoomRepository.save(ChatRoom.builder().title("잡담방").state(ChatRoomState.ACTIVE).build());

        chatParticipantRepository.save(ChatParticipant.builder().member(member1).ChatRoom(ChatRoom1).build());
        chatParticipantRepository.save(ChatParticipant.builder().member(member2).ChatRoom(ChatRoom1).build());

        chatParticipantRepository.save(ChatParticipant.builder().member(member1).ChatRoom(ChatRoom2).build());
        chatParticipantRepository.save(ChatParticipant.builder().member(member3).ChatRoom(ChatRoom2).build());

        chatParticipantRepository.save(ChatParticipant.builder().member(member1).ChatRoom(ChatRoom3).build());
        chatParticipantRepository.save(ChatParticipant.builder().member(member4).ChatRoom(ChatRoom3).build());

        // when
        List<ChatRoom> allChatRoomsForMember1 = getChatRoomService.findAllChatRooms(member1.getId());
        List<ChatRoom> allChatRoomsForMember2 = getChatRoomService.findAllChatRooms(member2.getId());

        // then
        assertThat(allChatRoomsForMember1).hasSize(3);
        assertThat(allChatRoomsForMember2).hasSize(1);
    }

}