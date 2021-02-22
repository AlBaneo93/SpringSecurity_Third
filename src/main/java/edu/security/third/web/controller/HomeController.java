package edu.security.third.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/*
 * Gradle에 spring-session-data-redis을 추가하고
 * Controller Class에 @EnableRedisHttpSession을 추가하면 세션 값들이 자동으로 redis에 저장된다
 * */
@Slf4j
@RestController
public class HomeController {

  @GetMapping("/api/hello")
  public String hello() {
    return "Hello Friends!!";
  }

//  @GetMapping("/")
//  public String index(HttpSession session) {
//    log.info("User Access");
//    session.setAttribute("name", "AlBan");
//    return session.getId() + "\nHello " + session.getAttribute("name ");
//
//  }
}