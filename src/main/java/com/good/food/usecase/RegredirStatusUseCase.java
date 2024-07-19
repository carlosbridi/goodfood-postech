package com.good.food.usecase;

import com.good.food.domains.Pedido;

public interface RegredirStatusUseCase {

  Pedido execute(String pedidoId);
  
}
