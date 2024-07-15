package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatMessageJpaRepository extends JpaRepository<ChatMessage, UUID> {

}
