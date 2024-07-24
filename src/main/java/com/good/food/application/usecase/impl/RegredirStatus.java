package com.good.food.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Pedido;
import com.good.food.application.usecase.RegredirStatusUseCase;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegredirStatus implements RegredirStatusUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public Pedido execute(String pedidoId) {
    Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
//    pedidoAtual.setStatus(pedidoAtual.getStatus().previous());
    return pedidoDatabaseGateway.save(pedidoAtual);
  }
}
