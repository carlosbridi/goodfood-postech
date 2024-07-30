package com.good.food.application.usecase.pedido;

import java.util.UUID;

import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.Pedido;

public class BuscarPedidoUseCaseImpl implements BuscarPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public BuscarPedidoUseCaseImpl(PedidoDatabaseGateway pedidoDatabaseGateway) {
    this.pedidoDatabaseGateway = pedidoDatabaseGateway;
  }

  @Override
  public Pedido execute(UUID uuid) {
    return pedidoDatabaseGateway.findById(uuid);
  }
}
