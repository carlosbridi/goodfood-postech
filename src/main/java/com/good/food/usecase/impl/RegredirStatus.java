package com.good.food.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.database.entity.EStatusPedido;
import com.good.food.usecase.RegredirStatusUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegredirStatus implements RegredirStatusUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public Pedido execute(String pedidoId) {
    final Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
    final EStatusPedido statusPedido = EStatusPedido.getByString(pedidoAtual.getStatus());
    pedidoAtual.setStatus(statusPedido.previous().name);
    return pedidoDatabaseGateway.save(pedidoAtual);
  }
}
