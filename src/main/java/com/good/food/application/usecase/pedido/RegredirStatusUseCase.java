package com.good.food.application.usecase.pedido;

import com.good.food.domain.Pedido;

public interface RegredirStatusUseCase {

  Pedido execute(String pedidoId);
  
}
