package com.good.food.gateways;

import com.good.food.domain.Pedido;

public interface PedidoDatabaseGateway {
    Pedido save(Pedido pedido);
}
