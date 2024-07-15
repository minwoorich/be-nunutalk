package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRoomJpaRepository extends JpaRepository<ChatRoom, UUID> {

}
