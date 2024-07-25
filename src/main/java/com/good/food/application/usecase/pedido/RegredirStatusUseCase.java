package com.good.food.application.usecase.pedido;

import com.good.food.application.entity.Pedido;

public interface RegredirStatusUseCase {

  Pedido execute(String pedidoId);
  
}
