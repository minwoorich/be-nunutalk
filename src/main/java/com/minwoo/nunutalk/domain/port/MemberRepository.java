package com.minwoo.nunutalk.domain.port;

import com.minwoo.nunutalk.domain.Member;

import java.util.UUID;

public interface MemberRepository {
    Member findById(UUID id);
    Member save(Member member);
}
