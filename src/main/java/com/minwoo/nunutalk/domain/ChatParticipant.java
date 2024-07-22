package com.minwoo.nunutalk.domain;

import com.minwoo.nunutalk.domain.uuid.GeneratedUuid;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "chat_participant")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatParticipant extends BaseEntity {
    @Id @GeneratedUuid
    @Column(name = "chat_participant_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private ChatParticipant(UUID id, ChatRoom chatRoom, Member member) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.member = member;
    }

    public void linkChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void linkMember(Member member) {
        this.member = member;
    }
}
