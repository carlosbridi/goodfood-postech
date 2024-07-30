package com.good.food.application.usecase.pedido;

import com.good.food.domain.Pedido;

public interface WebhookPedidoUseCase {

    Pedido execute(String idPedido);
}
