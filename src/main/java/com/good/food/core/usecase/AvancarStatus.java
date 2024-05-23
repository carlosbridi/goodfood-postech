package com.good.food.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Pedido;
import com.good.food.core.ports.inbound.AvancarStatusUseCase;
import com.good.food.core.ports.outbound.PedidoDatabaseGateway;
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
