package com.good.food.usecase.pedido;

import java.util.List;
import org.springframework.stereotype.Component;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import com.good.food.domain.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarTodosPedidosAbertosUseCaseImpl implements BuscarTodosPedidosAbertosUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    public List<Pedido> execute() {
        return pedidoDatabaseGateway.findAllByStatusNotFinalizadoOrderByStatusAndDate();
//        return pedidos.stream().map(pedidoPresenter::toResponse).collect(Collectors.toList());
    }
}
