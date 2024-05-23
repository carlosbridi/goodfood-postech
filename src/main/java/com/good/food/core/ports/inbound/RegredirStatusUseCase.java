package com.good.food.core.ports.inbound;

import com.good.food.core.domain.Pedido;

public interface RegredirStatusUseCase {

  Pedido execute(String pedidoId);
  
}
