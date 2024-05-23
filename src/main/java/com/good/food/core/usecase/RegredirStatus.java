package com.good.food.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Pedido;
import com.good.food.core.ports.inbound.RegredirStatusUseCase;
import com.good.food.core.ports.outbound.PedidoDatabaseGateway;
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
