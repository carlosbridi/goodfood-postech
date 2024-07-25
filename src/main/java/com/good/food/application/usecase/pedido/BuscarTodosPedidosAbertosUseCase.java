package com.good.food.application.usecase.pedido;

import java.util.List;
import com.good.food.application.entity.Pedido;

public interface BuscarTodosPedidosAbertosUseCase {

  List<Pedido> execute();
  
}
