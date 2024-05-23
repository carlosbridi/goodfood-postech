package com.good.food.core.ports.outbound;

import com.good.food.core.domain.ItemPedido;

public interface ItemPedidoDatabaseGateway {

    ItemPedido save(ItemPedido item);
}
