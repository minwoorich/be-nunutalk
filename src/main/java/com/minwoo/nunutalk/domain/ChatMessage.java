package com.minwoo.nunutalk.domain;

import com.minwoo.nunutalk.domain.enums.MessageType;
import com.minwoo.nunutalk.domain.uuid.GeneratedUuid;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "chat_message")
@ToString
public class ChatMessage extends BaseEntity{

    @Id
    @GeneratedUuid
    @Column(name = "message_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Member sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;
    
    @Lob
    @Column(columnDefinition="TEXT")
    private String msg;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @Builder
    private ChatMessage(UUID id, Member sender, ChatRoom chatRoom, String msg, MessageType messageType) {
        this.id = id;
        this.sender = sender;
        this.chatRoom = chatRoom;
        this.msg = msg;
        this.messageType = messageType;
    }
}
