package com.good.food.application.usecase.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Pedido;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import com.good.food.driver.db.repository.entity.EStatusPedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class RegredirStatus implements RegredirStatusUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public Pedido execute(String pedidoId) {
    final Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
    final EStatusPedido statusPedido = EStatusPedido.getByString(pedidoAtual.getStatus());
    pedidoAtual.setStatus(statusPedido.previous().name);
    return pedidoDatabaseGateway.save(pedidoAtual);
  }
}
