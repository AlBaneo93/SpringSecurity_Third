package edu.security.third.web.oauth;

import edu.security.third.web.vo.Member;
import edu.security.third.web.vo.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class OAuthAttributes {
  private Map<String, Object> attributes;

  private String nameAttributeKey;

  private String name;

  private String email;

  private String picture;

  public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
    if ("naver".equals(registrationId)) {
      return ofNaver("id", attributes);
    }
    return ofGoogle(userNameAttributeName, attributes);
  }

  private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
    return OAuthAttributes.builder()
                          .name((String) attributes.get("name"))
                          .email((String) attributes.get("email"))
                          .picture((String) attributes.get("picture"))
                          .attributes(attributes)
                          .nameAttributeKey(userNameAttributeName)
                          .build();
  }

  private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
    Map<String, Object> response = (Map<String, Object>) attributes.get("response");
    return OAuthAttributes.builder()
                          .name((String) response.get("name"))
                          .email((String) response.get("email"))
                          .picture((String) response.get("profile_image"))
                          .attributes(response)
                          .nameAttributeKey(userNameAttributeName)
                          .build();
  }

  /*
  * Member Entity 생성
  * 사용자가 처음 가입시 기본 값으로 멤버 엔티티를 생성하기 위함
  * */
  public Member toEntity() {
    return Member.builder()
                 .name(name)
                 .email(email)
                 .picture(picture)
                 .role(Role.USER) // OAuth로그인 유저의 기본값 설정
                 .build();
  }
}