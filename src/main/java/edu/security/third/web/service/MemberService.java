//package edu.security.third.web.service;
//
//import edu.security.third.web.Exceptions.UserEmailNotFoundException;
//import edu.security.third.web.vo.Member;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//public interface MemberService extends UserDetailsService {
//  @Override
//  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
//
//  public Member save(Member member);
//
//
//  public Boolean delete(String email);
//
//  public Member get(String email) throws UserEmailNotFoundException;
//
//  public List<Member> getAll();
//}