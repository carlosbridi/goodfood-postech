package com.good.food.usecase.usecase.pedido;

import java.util.UUID;

import com.good.food.usecase.usecase.pedido.response.PedidoResponse;

public interface BuscarPedidoUseCase {

  PedidoResponse execute(UUID uuid);

}
