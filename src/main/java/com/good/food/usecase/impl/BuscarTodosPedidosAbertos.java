package com.good.food.usecase.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.usecase.BuscarTodosPedidosAbertosUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarTodosPedidosAbertos implements BuscarTodosPedidosAbertosUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public List<Pedido> execute() {
    return pedidoDatabaseGateway.findAll();
  }
}
