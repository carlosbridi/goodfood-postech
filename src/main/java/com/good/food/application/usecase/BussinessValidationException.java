package com.good.food.application.usecase;

public class BussinessValidationException extends RuntimeException {

  private static final long serialVersionUID = -1104311020397886380L;

  public BussinessValidationException(String message) {
    super(message);
  }

  public BussinessValidationException(String message, Throwable e) {
    super(message, e);
  }

}
