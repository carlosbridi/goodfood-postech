package com.good.food.adapter.outbound;

import org.springframework.stereotype.Component;
import com.good.food.adapter.outbound.repository.ItemPedidoRepository;
import com.good.food.adapter.outbound.repository.entity.ItemPedidoEntity;
import com.good.food.core.domain.ItemPedido;
import com.good.food.core.ports.outbound.ItemPedidoDatabaseGateway;
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
