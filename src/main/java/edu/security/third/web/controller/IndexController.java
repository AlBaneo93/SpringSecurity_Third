package edu.security.third.web.controller;

import edu.security.third.web.oauth.SessionUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class IndexController {

  private final PostsService postsService;

  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("posts", postsService.findAllDesc());

    SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
    if (sessionUser != null) {
      model.addAttribute("userName", sessionUser.getName());
    }

    return "index";
  }
}