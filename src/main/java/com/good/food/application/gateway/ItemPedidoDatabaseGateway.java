package com.good.food.application.gateway;

import com.good.food.domain.ItemPedido;

public interface ItemPedidoDatabaseGateway {

    ItemPedido save(ItemPedido item);
}
