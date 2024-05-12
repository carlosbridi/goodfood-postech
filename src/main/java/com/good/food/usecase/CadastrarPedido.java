package com.good.food.usecase;

import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarPedido {

    @Autowired
    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    public Pedido execute(Pedido pedido) {
        return pedidoDatabaseGateway.save(pedido);
    }

}
