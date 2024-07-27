package com.good.food.domain.usecase.pedido;

import com.good.food.domain.usecase.pedido.response.PedidoResponse;

public interface RegredirStatusUseCase {

  PedidoResponse execute(String pedidoId);
  
}
