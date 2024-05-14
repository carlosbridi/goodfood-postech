package com.good.food.gateways;

import com.good.food.domain.ItemPedido;
import com.good.food.repository.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemPedidoDatabaseGatewayImpl implements ItemPedidoDatabaseGateway{

    @Autowired
    private final ItemPedidoRepository itemPedidoRepository;
    
    @Override
    public ItemPedido save(ItemPedido item) {
        return itemPedidoRepository.save(item);
    }
}
