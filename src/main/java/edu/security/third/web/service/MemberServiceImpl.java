package edu.security.third.web.service;

import edu.security.third.web.Exceptions.UserEmailNotFoundException;
import edu.security.third.web.repository.MemberRepository;
import edu.security.third.web.vo.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberServiceTest {

  private MemberRepository memberRepository;

  //  @Override
  //  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  //    return null;
  //  }

  @Override
  public Member save(Member member) {
    return memberRepository.save(member);
  }

  @Override
  public Boolean delete(String email) {
    return memberRepository.deleteMemberByEmail(email);
  }

  @Override
  public Member get(String email) throws UserEmailNotFoundException {
    return memberRepository.findByEmail(email).orElseThrow(() ->
        new UserEmailNotFoundException(email + " was not found")
    );
  }

  @Override
  public List<Member> getAll() {
    return memberRepository.findAll();
  }
}