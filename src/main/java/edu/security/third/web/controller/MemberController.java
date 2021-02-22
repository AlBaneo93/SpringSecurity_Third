package edu.security.third.web.controller;

import edu.security.third.web.Exceptions.UserEmailNotFoundException;
import edu.security.third.web.service.MemberService;
import edu.security.third.web.vo.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v2")
@AllArgsConstructor
@EnableRedisHttpSession
public class MemberController {

  private MemberService memberService;

  @GetMapping("/member/{email}")
  public ResponseEntity<Map<String, Object>> getMember(@PathVariable String email) {
    log.info("Get Member: " + email);
    Map<String, Object> map = new HashMap<>();
    try {
      map.put("result", memberService.get(email));
    } catch (UserEmailNotFoundException e) {
      map.put("err", e.getMessage());
    }
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/members")
  public ResponseEntity<Map<String, Object>> getAllMembers() {
    log.info("Get All Members");
    Map<String, Object> map = new HashMap<>();
    map.put("result", memberService.getAll());
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping("/member")
  public ResponseEntity<Map<String, Object>> postMember(@RequestBody Member member) {
    log.info("Member SignUp");
    Map<String, Object> map = new HashMap<>();

    map.put("result", memberService.save(member));
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PutMapping("/member/{email}")
  public ResponseEntity<Map<String, Object>> putMember(@RequestBody Member member) {
    log.info("Modified Member Info");
    Map<String, Object> map = new HashMap<>();
    map.put("result", memberService.save(member));
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @DeleteMapping("/member/{email}")
  public ResponseEntity<Map<String, Object>> deleteMember(@PathVariable String email) {
    log.info("Delete Member Info: " + email);
    Map<String, Object> map = new HashMap<>();
    map.put("result", memberService.delete(email));
    return new ResponseEntity<>(map, HttpStatus.OK);
  }
}