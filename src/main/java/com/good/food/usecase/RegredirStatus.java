package com.good.food.usecase;

import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RegredirStatus {

    @Autowired
    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    public Pedido execute(String pedidoId){
        Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
        pedidoAtual.setStatus(pedidoAtual.getStatus().previous());
        return pedidoDatabaseGateway.save(pedidoAtual);
    }
}
