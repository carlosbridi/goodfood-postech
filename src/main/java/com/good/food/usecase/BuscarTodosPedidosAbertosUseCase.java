package com.good.food.usecase;

import java.util.List;
import com.good.food.domains.Pedido;

public interface BuscarTodosPedidosAbertosUseCase {

  List<Pedido> execute();
  
}
