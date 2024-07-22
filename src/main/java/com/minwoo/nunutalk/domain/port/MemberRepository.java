package com.minwoo.nunutalk.domain.port;

import com.minwoo.nunutalk.domain.Member;

import java.util.List;
import java.util.UUID;

public interface MemberRepository {
    Member findById(UUID id);
    Member save(Member member);
    List<Member> findAllIn(List<UUID> ids);
}
