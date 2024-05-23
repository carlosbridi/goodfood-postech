package com.good.food.core.usecase;

import java.util.UUID;
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

  public Pedido execute(UUID uuid) {
    return pedidoDatabaseGateway.findById(uuid);
  }
}
