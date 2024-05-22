package com.good.food.gateways;

import java.util.List;
import java.util.UUID;
import com.good.food.domain.Pedido;

public interface PedidoDatabaseGateway {

  Pedido save(Pedido pedido);

  Pedido findById(String uuid);

  Pedido findById(UUID uuid);

  List<Pedido> findAll();
  
}
