package com.good.food.domain.usecase.pedido;

import com.good.food.domain.usecase.pedido.response.PedidoResponse;

public interface AvancarStatusUseCase {

  PedidoResponse execute(String pedidoId);
}
