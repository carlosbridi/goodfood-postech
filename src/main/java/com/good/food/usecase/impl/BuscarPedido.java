package com.good.food.usecase.impl;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.usecase.BuscarPedidoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarPedido implements BuscarPedidoUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  @Override
  public Pedido execute(UUID uuid) {
    return pedidoDatabaseGateway.findById(uuid);
  }
}
