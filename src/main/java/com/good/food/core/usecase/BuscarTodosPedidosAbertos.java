package com.good.food.core.usecase;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarTodosPedidosAbertos {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public List<Pedido> execute() {
    return pedidoDatabaseGateway.findAll();
  }
}
