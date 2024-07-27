package com.good.food.usecase.pedido;

import org.springframework.stereotype.Component;
import com.good.food.adapter.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class RegredirStatusUseCaseImpl implements RegredirStatusUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public Pedido execute(String pedidoId) {
    final Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
    final EStatusPedido statusPedido = pedidoAtual.getStatus();
    pedidoAtual.setStatus(statusPedido.previous());
    return pedidoDatabaseGateway.save(pedidoAtual);
  }
}
