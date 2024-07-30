package com.good.food.application.usecase.pedido;

import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.Pedido;

public class AvancarStatusUseCaseImpl implements AvancarStatusUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public AvancarStatusUseCaseImpl(PedidoDatabaseGateway pedidoDatabaseGateway) {
    this.pedidoDatabaseGateway = pedidoDatabaseGateway;
  }

  public Pedido execute(String pedidoId) {
    final Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
    final EStatusPedido statusPedido = pedidoAtual.getStatus();
    pedidoAtual.setStatus(statusPedido.next());
    return pedidoDatabaseGateway.save(pedidoAtual);
  }
}
