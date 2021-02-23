package edu.security.third.web.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SocialType {
  GOOGLE("구글"),
  FACEBOOK("페이스북"),
  NAVER("네이버"),
  KAKAO("카카오");

  private String value;

}