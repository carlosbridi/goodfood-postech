package com.good.food.domain;

public enum EProdutoCategoria {

  BEBIDA,
  LANCHE,
  SOBREMESA,
  ACOMPANHAMENTO;
  
  public EProdutoCategoria getByString(final String categoria) {
    return EProdutoCategoria.valueOf(categoria);
  }
  
}
