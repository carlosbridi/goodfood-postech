package com.good.food.domain.exception;

public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = -1104311020397886380L;

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Throwable e) {
    super(message, e);
  }

}
