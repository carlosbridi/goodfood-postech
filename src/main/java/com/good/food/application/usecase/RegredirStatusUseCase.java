package com.good.food.application.usecase;

import com.good.food.application.entity.Pedido;

public interface RegredirStatusUseCase {

  Pedido execute(String pedidoId);
  
}
