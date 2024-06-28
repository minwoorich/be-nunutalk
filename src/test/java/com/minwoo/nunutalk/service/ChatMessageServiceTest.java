package com.minwoo.nunutalk.service;

import com.minwoo.nunutalk.domain.ChatMessage;
import com.minwoo.nunutalk.domain.port.ChatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class ChatMessageServiceTest {

    @Autowired ChatRepository chatRepository;

    @Test
    void save() {
        // given
        ChatMessage chatMessage = ChatMessage.builder().sender("홍길동").msg("안녕하세요 저는 홍길동 입니다").build();

        // when
        chatRepository.save(chatMessage);
        ChatMessage findChatMessage = chatRepository.findById(chatMessage.getId());

        // then
        assertThat(findChatMessage)
                .extracting("sender", "msg")
                .contains(chatMessage.getSender(), chatMessage.getMsg());
    }
}