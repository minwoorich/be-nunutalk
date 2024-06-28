package com.minwoo.nunutalk.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    
    @Lob
    @Column(columnDefinition="TEXT")
    private String msg;

    @Builder
    private ChatMessage(String msg, String sender) {
        this.msg = msg;
        this.sender = sender;
    }
}
