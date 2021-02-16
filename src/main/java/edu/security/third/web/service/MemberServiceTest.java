package edu.security.third.web.service;

import edu.security.third.web.Exceptions.UserEmailNotFoundException;
import edu.security.third.web.vo.Member;

import java.util.List;

public interface MemberServiceTest {

  Member save(Member member);


  Boolean delete(String email);

  Member get(String email) throws UserEmailNotFoundException;

  List<Member> getAll();
}