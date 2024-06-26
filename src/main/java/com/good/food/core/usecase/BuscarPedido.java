package com.good.food.core.usecase;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Pedido;
import com.good.food.core.ports.inbound.BuscarPedidoUseCase;
import com.good.food.core.ports.outbound.PedidoDatabaseGateway;
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
