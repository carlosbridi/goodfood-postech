package com.good.food.application.usecase.pedido;

import java.util.UUID;

import com.good.food.domain.Pedido;

public interface BuscarPedidoUseCase {

  Pedido execute(UUID uuid);

}
