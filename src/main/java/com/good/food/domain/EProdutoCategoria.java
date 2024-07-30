package com.good.food.domain;

public enum EProdutoCategoria {

  BEBIDA,
  LANCHE,
  SOBREMESA,
  ACOMPANHAMENTO;
  
  public static EProdutoCategoria getByString(final String categoria) {
    try {
      return EProdutoCategoria.valueOf(categoria);
    } catch (Exception e) {
      throw new IllegalArgumentException("Tipo incompatível, tipos disponíveis: LANCHE, BEBIDA, ACOMPANHAMENTO e SOBREMESA");
    }
  }
  
}
