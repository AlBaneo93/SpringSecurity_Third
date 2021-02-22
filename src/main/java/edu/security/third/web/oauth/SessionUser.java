package edu.security.third.web.oauth;

import edu.security.third.web.vo.Member;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class SessionUser implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String picture;

  public SessionUser(Member member) {
    this.name = member.getName();
    this.email = member.getEmail();
    this.picture = member.getPicture();
  }
}