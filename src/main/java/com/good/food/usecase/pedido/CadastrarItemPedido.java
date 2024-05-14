package com.good.food.usecase.pedido;

import com.good.food.domain.ItemPedido;
import com.good.food.gateways.ItemPedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarItemPedido {

    @Autowired
    private final ItemPedidoDatabaseGateway itemPedidoDatabaseGateway;

    public ItemPedido execute(ItemPedido itemPedido) {
        return itemPedidoDatabaseGateway.save(itemPedido);
    }

}
