package com.good.food.usecase;

import com.good.food.domains.Pedido;

public interface AvancarStatusUseCase {

  Pedido execute(String pedidoId);
}
