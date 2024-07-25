package com.good.food.application.usecase.pedido;

import com.good.food.application.entity.Pedido;

public interface AvancarStatusUseCase {

  Pedido execute(String pedidoId);
}
