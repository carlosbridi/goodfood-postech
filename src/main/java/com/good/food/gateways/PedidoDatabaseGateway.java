package com.good.food.gateways;

import com.good.food.domain.Pedido;

import java.util.List;

public interface PedidoDatabaseGateway {
    Pedido save(Pedido pedido);

    Pedido findById(String uuid);

    List<Pedido> findAll();
}
