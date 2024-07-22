package com.minwoo.nunutalk.infrastructure;

import com.minwoo.nunutalk.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberJpaRepository extends JpaRepository<Member, UUID> {

}
