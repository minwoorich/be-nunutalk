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
    private ChatRoom ChatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private ChatParticipant(UUID id, ChatRoom ChatRoom, Member member) {
        this.id = id;
        this.ChatRoom = ChatRoom;
        this.member = member;
    }

    public void linkChatRoom(ChatRoom ChatRoom) {
        this.ChatRoom = ChatRoom;
    }

    public void linkMember(Member member) {
        this.member = member;
    }

    public static ChatParticipant create(ChatRoom ChatRoom, Member member) {
        return ChatParticipant.builder().member(member).ChatRoom(ChatRoom).build();
    }
}
