package com.good.food.gateways;

import org.springframework.stereotype.Component;
import com.good.food.domain.ItemPedido;
import com.good.food.repository.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemPedidoDatabaseGatewayImpl implements ItemPedidoDatabaseGateway {

  private final ItemPedidoRepository itemPedidoRepository;

  @Override
  public ItemPedido save(ItemPedido item) {
    return itemPedidoRepository.save(item);
  }
}
