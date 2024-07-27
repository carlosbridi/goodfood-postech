package com.good.food.usecase.usecase.pedido;

import com.good.food.usecase.usecase.pedido.response.PedidoResponse;

public interface WebhookPedidoUseCase {

    PedidoResponse execute(String idPedido);
}
