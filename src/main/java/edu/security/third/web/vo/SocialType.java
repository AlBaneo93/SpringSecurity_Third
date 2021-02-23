package edu.security.third.web.vo;

import lombok.AllArgsConstructor;

/*
 * 로그인한 유저의 타입을 구별하기 위한 Enum 클래스
 * */
@AllArgsConstructor
public enum SocialType {
  GOOGLE("GOOGLE", "구글"),
  NAVER("NAVER", "네이버"),
  KAKAO("KAKAO", "카카오"),
  FACEBOOK("FACEBOOK", "페이스북"),
  LOCAL("LOCAL", "로컬");

  private String value;

  private String key;
}