package edu.security.third.web.repository;

import edu.security.third.web.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByEmail(String email);

  Boolean deleteMemberByEmail(String email);
}