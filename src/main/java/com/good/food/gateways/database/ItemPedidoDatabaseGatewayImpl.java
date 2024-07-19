package com.good.food.gateways.database;

import org.springframework.stereotype.Component;
import com.good.food.domains.ItemPedido;
import com.good.food.gateways.ItemPedidoDatabaseGateway;
import com.good.food.gateways.database.entity.ItemPedidoEntity;
import com.good.food.gateways.database.repositories.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemPedidoDatabaseGatewayImpl implements ItemPedidoDatabaseGateway {

  private final ItemPedidoRepository itemPedidoRepository;

  @Override
  public ItemPedido save(ItemPedido item) {
    return itemPedidoRepository.save(new ItemPedidoEntity(item)).toDomain();
  }
}
