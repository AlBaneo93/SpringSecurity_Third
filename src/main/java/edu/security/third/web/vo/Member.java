package edu.security.third.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;  // 유저 식별 값

  @Column(nullable = false)
  private String email; // 유저의 실제 사용 아이디

  @Column(nullable = false)
  private String password;

  private String name;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Role role;

  private String picture; // Profile Image

  public Member update(String name, String picture) {
    this.name = name;
    this.picture = picture;

    return this;
  }

  public String getRoleKey() {
    return this.role.getKey();
  }
}