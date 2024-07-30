package com.good.food.usecase.pedido;

import com.good.food.domain.Pedido;

public interface WebhookPedidoUseCase {

    Pedido execute(String idPedido);
}
