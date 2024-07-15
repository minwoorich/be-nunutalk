package com.minwoo.nunutalk.domain;

import com.minwoo.nunutalk.domain.uuid.GeneratedUuid;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "member_room")
public class MemberRoom extends BaseEntity {
    @Id @GeneratedUuid
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}