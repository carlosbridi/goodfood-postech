package com.good.food.usecase.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarPedido {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public Pedido execute(String uuid) {
    return pedidoDatabaseGateway.findById(uuid);
  }
}
