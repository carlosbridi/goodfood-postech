package com.good.food.usecase.usecase.pedido;

import com.good.food.usecase.usecase.pedido.response.PedidoResponse;

public interface RegredirStatusUseCase {

  PedidoResponse execute(String pedidoId);
  
}
