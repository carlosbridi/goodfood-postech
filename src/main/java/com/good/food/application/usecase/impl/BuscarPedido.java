package com.good.food.application.usecase.impl;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Pedido;
import com.good.food.application.usecase.BuscarPedidoUseCase;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
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
