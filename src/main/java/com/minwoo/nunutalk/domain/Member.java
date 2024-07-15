package com.minwoo.nunutalk.domain;

import com.minwoo.nunutalk.domain.uuid.GeneratedUuid;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id @GeneratedUuid
    @Column(name = "member_id")
    private UUID id;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "email")
    private String email;

    @Builder
    private Member(UUID id, String memberName, String email) {
        this.id = id;
        this.memberName = memberName;
        this.email = email;
    }
}