package com.minwoo.nunutalk.domain;

import com.minwoo.nunutalk.domain.uuid.GeneratedUuid;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom {

    @Id
    @GeneratedUuid
    private UUID id;
    private String title;
    private String state;

    @Builder
    private ChatRoom(UUID id, String title, String state) {
        this.id = id;
        this.title = title;
        this.state = state;
    }
}
