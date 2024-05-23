package com.good.food.core.ports.inbound;

import java.util.List;
import com.good.food.core.domain.Pedido;

public interface BuscarTodosPedidosAbertosUseCase {

  List<Pedido> execute();
  
}
