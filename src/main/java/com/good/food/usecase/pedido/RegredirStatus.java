package com.good.food.usecase.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegredirStatus {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public Pedido execute(String pedidoId) {
    Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
//    pedidoAtual.setStatus(pedidoAtual.getStatus().previous());
    return pedidoDatabaseGateway.save(pedidoAtual);
  }
}
