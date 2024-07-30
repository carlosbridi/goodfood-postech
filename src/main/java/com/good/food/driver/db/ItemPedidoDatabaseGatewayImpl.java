package com.good.food.driver.db;

import org.springframework.stereotype.Component;
import com.good.food.driver.db.repository.entity.ItemPedidoEntity;
import com.good.food.domain.ItemPedido;
import com.good.food.application.gateway.ItemPedidoDatabaseGateway;
import com.good.food.driver.db.repository.ItemPedidoRepository;
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
