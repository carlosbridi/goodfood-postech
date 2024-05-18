package com.good.food.domain.exceptions;

public class PedidoNotFoundException extends NotFoundException {

  private static final long serialVersionUID = -1104311020397886380L;

  public PedidoNotFoundException(String message) {
    super(message);
  }

  public PedidoNotFoundException(String message, Throwable e) {
    super(message, e);
  }

}
