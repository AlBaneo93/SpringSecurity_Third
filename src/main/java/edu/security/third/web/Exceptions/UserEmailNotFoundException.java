package edu.security.third.web.Exceptions;

public class UserEmailNotFoundException extends Exception {
  public UserEmailNotFoundException() {
  }

  public UserEmailNotFoundException(String message) {
    super(message);
  }
}