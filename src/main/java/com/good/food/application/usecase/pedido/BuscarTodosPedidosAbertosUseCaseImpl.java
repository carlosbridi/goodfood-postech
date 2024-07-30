package com.good.food.application.usecase.pedido;

import java.util.List;

import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.Pedido;

public class BuscarTodosPedidosAbertosUseCaseImpl implements BuscarTodosPedidosAbertosUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    public BuscarTodosPedidosAbertosUseCaseImpl(PedidoDatabaseGateway pedidoDatabaseGateway) {
        this.pedidoDatabaseGateway = pedidoDatabaseGateway;
    }

    public List<Pedido> execute() {
        return pedidoDatabaseGateway.findAllByStatusNotFinalizadoOrderByStatusAndDate();
//        return pedidos.stream().map(pedidoPresenter::toResponse).collect(Collectors.toList());
    }
}
