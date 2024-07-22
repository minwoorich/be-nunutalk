package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatParticipant;
import com.minwoo.nunutalk.domain.ChatRoom;
import com.minwoo.nunutalk.domain.port.ChatRoomRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ChatParticipantJpaRepositoryTest {

    @Autowired ChatParticipantJpaRepository chatParticipantJpaRepository;
    @Autowired ChatRoomRepository chatRoomRepository;

    @Rollback(value = false)
    @Test
    @DisplayName("memberId 로 ChatParticipant 를 DB 로부터 가져올 수 있다")
    void findByMemberId() {

        // given
        ChatParticipant savedEntity = chatParticipantJpaRepository.save(ChatParticipant.builder().build());
        // when
        ChatParticipant chatParticipant = chatParticipantJpaRepository.findById(savedEntity.getId()).get();
        // then
        assertThat(chatParticipant).isNotNull();
    }

    @Test
    @DisplayName("chat_room_id 로 연관된 ChatParticipant 모두를 조회할 수 있다")
    void findByChatRoomId() {
        // given
        ChatRoom chatRoom = chatRoomRepository.save(ChatRoom.builder().build());

        chatParticipantJpaRepository.save(ChatParticipant.builder().chatRoom(chatRoom).build());
        chatParticipantJpaRepository.save(ChatParticipant.builder().chatRoom(chatRoom).build());
        chatParticipantJpaRepository.save(ChatParticipant.builder().chatRoom(chatRoom).build());

        // when
        List<ChatParticipant> chatRooms = chatParticipantJpaRepository.findByChatRoomId(chatRoom.getId());

        // then
        assertThat(chatRooms).hasSize(3);
    }
}