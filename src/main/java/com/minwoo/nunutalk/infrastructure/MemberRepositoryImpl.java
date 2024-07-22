package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.Member;
import com.minwoo.nunutalk.domain.port.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member findById(UUID id) {
        return memberJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find Member with id: " + id));
    }

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public List<Member> findAllIn(List<UUID> ids) {
        return memberJpaRepository.findAllById(ids);
    }
}
