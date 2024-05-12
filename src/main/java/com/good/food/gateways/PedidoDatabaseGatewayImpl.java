package com.good.food.gateways;

import com.good.food.domain.Pedido;
import com.good.food.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PedidoDatabaseGatewayImpl implements PedidoDatabaseGateway {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
