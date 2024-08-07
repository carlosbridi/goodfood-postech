package com.good.food.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatusPagamentoPedido {

    PENDENTE("Pendente"), //
    PAGO("Pago"), //
    RECUSADO("Recusado");

    public String name;

}
