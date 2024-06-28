package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatJpaRepository extends JpaRepository<ChatMessage, Long> {

}
