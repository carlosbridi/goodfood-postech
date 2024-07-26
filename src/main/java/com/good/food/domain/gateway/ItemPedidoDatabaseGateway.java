package com.good.food.domain.gateway;

import com.good.food.domain.entity.ItemPedido;

public interface ItemPedidoDatabaseGateway {

    ItemPedido save(ItemPedido item);
}
