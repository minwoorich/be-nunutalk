package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.api.dto.CreateRoomDto;
import com.minwoo.nunutalk.domain.ChatParticipant;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.Member;
import com.minwoo.nunutalk.domain.port.ChatParticipantRepository;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import com.minwoo.nunutalk.domain.port.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static com.minwoo.nunutalk.domain.enums.ChatRoomState.ACTIVE;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles(value = "test")
@Transactional
class CreateChatRoomServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired ChatRoomRepository chatRoomRepository;
    @Autowired CreateChatRoomService createChatRoomService;
    @Autowired ChatParticipantRepository chatParticipantRepository;

    @Test
    @DisplayName("채팅방을 생성하고 활성화 한다")
    void create() {
        // given
        Member member1 = memberRepository.save(Member.builder().memberName("홍길동").build());
        Member member2 = memberRepository.save(Member.builder().memberName("박길동").build());
        Member member3 = memberRepository.save(Member.builder().memberName("정길동").build());
        Member member4 = memberRepository.save(Member.builder().memberName("오길동").build());
        List<UUID> memberIds = List.of(member1.getId(), member2.getId(), member3.getId(), member4.getId());

        CreateRoomDto chatRoomDto = CreateRoomDto.builder().title("독서 스터디 모임입니다").memberIds(memberIds).build();

        // when
        ChatRoom chatRoom = createChatRoomService.create(chatRoomDto);

        // then
        assertThat(chatRoom).isNotNull();
        assertThat(chatRoom)
                .extracting("title", "state")
                .contains(chatRoomDto.title(), ACTIVE);
    }

    @Test
    @DisplayName("채팅방에는 채팅방 주인 및 초대한 인원들이 참가되어있어야한다")
    void create2() {
        // given
        Member member1 = memberRepository.save(Member.builder().memberName("홍길동").build());
        Member member2 = memberRepository.save(Member.builder().memberName("박길동").build());
        Member member3 = memberRepository.save(Member.builder().memberName("정길동").build());
        Member member4 = memberRepository.save(Member.builder().memberName("오길동").build());
        List<UUID> memberIds = List.of(member1.getId(), member2.getId(), member3.getId(), member4.getId());

        CreateRoomDto chatRoomDto = CreateRoomDto.builder().title("독서 스터디 모임입니다").memberIds(memberIds).build();

        // when
        ChatRoom chatRoom = createChatRoomService.create(chatRoomDto);
        List<Member> members = chatParticipantRepository
                .findByChatRoomId(chatRoom.getId()).stream().map(ChatParticipant::getMember).toList();

        // then
        assertThat(members).hasSize(4)
                .extracting("memberName")
                .contains(member1.getMemberName())
                .contains(member2.getMemberName())
                .contains(member3.getMemberName())
                .contains(member4.getMemberName());
    }
}