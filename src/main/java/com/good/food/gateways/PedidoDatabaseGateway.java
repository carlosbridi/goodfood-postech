package com.good.food.gateways;

import com.good.food.domain.Pedido;

import java.util.UUID;

public interface PedidoDatabaseGateway {
    Pedido save(Pedido pedido);

    Pedido findById(String uuid);
    Pedido findById(UUID uuid);
}
