package com.minwoo.nunutalk.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatPariticipantJpaRepositoryTest {

    @Autowired ChatPariticipantJpaRepository chatPariticipantJpaRepository;

    @Test
    @DisplayName("memberId 로 ChatParticipant 를 DB로부터 가져올 수 있다")
    void findByMemberId() {

    }

    @Test
    void findByChatRoomId() {
    }
}