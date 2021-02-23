package edu.security.third.web.controller;

import edu.security.third.web.oauth.LoginUser;
import edu.security.third.web.oauth.SessionUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@Slf4j
@Controller
public class IndexController {

  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model, @LoginUser SessionUser user) {
    // 주석처리된 SessionUser는 LoginUser 어노테이션으로 대체되어 사용됨
    //    SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");

    if (user != null) {
      log.info(user.toString());
      model.addAttribute("username", user.getName());
    }

    return "index";
  }
}