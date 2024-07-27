package com.good.food.adapter.gateway.db;

import org.springframework.stereotype.Component;

import com.good.food.usecase.gateway.ItemPedidoDatabaseGateway;
import com.good.food.adapter.gateway.db.repository.entity.ItemPedidoEntity;
import com.good.food.adapter.gateway.db.repository.ItemPedidoRepository;
import com.good.food.domain.entity.ItemPedido;
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
