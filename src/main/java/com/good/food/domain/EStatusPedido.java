package com.good.food.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatusPedido {

  RECEBIDO("Recebido"),
  EM_PREPARACAO("Em preparação"),
  PRONTO("Pronto"),
  FINALIZADO("Finalizado");
  
  public String name;
  
  private static final EStatusPedido[] vals = values();

  public EStatusPedido next(){
    if(this == FINALIZADO){
      return FINALIZADO;
    }
    return vals[(this.ordinal() + 1) % vals.length];
  }

  public EStatusPedido previous(){
    if(this == RECEBIDO){
      return RECEBIDO;
    }
    return vals[(this.ordinal() - 1) % vals.length];

  }
}
