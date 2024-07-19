package com.good.food.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.usecase.AvancarStatusUseCase;
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
