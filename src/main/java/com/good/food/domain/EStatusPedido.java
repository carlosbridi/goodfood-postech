package com.good.food.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatusPedido {

  RECEBIDO("Recebido"),
  EM_PREPARACAO("Em preparação"),
  PRONTO("Pronto"),
  FINALIZADO("Finalizado");
  
  public String name;

  public static EStatusPedido getByString(final String status) {
    try {
      return EStatusPedido.valueOf(status);
    } catch (Exception e) {
      throw new IllegalArgumentException("Tipo incompatível, tipos disponíveis: RECEBIDO, EM_PREPARACAO, PRONTO e FINALIZADO");
    }
  }
  
}
