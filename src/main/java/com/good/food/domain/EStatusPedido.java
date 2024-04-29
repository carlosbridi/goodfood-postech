package com.good.food.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatusPedido {

  RECEBIDO("Recebido"),
  EM_PREPARACAO("Em preparação"),
  PRONTO("Pronto"),
  FINALIZADO("Finalizado");
  
  public String name;
  
}
