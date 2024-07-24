package com.good.food.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Pedido;
import com.good.food.application.usecase.AvancarStatusUseCase;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AvancarStatus implements AvancarStatusUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public Pedido execute(String pedidoId) {
    Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
    //Avaliar
//    pedidoAtual.setStatus(pedidoAtual.getStatus().next());
    return pedidoDatabaseGateway.save(pedidoAtual);
  }
}
