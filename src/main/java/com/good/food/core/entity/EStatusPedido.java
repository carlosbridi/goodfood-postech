package com.good.food.core.entity;

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
      throw new IllegalArgumentException("Tipo incompatível, tipos disponíveis: Recebido, Em Preparação, Pronto e Finalizado");
    }
  }
  
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
