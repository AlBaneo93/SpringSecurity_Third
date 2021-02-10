package edu.security.third.web.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {

  USER("ROLE_USER"),
  ADMIN("ROLE_ADMIN");

  private String value;
}