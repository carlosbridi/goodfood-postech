package com.good.food.usecase.pedido;

import com.good.food.domain.Pedido;

public interface AvancarStatusUseCase {

  Pedido execute(String pedidoId);
}
