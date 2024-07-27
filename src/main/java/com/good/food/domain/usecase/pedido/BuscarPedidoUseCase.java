package com.good.food.domain.usecase.pedido;

import java.util.UUID;

import com.good.food.domain.usecase.pedido.response.PedidoResponse;

public interface BuscarPedidoUseCase {

  PedidoResponse execute(UUID uuid);

}
