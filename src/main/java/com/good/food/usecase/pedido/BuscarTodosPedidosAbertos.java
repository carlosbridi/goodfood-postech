package com.good.food.usecase.pedido;

import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarTodosPedidosAbertos {

    @Autowired
    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    public List<Pedido> execute(){
        return pedidoDatabaseGateway.findAll();
    }
}
