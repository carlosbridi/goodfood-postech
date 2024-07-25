package com.good.food.application.usecase.pedido;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Pedido;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarTodosPedidosAbertos implements BuscarTodosPedidosAbertosUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  public List<Pedido> execute() {
    return pedidoDatabaseGateway.findAllByStatusNotFinalizadoOrderByStatusAndDate();
  }
}
