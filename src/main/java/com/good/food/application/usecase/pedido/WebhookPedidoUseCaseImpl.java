package com.good.food.application.usecase.pedido;

import org.springframework.stereotype.Component;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPagamentoPedido;
import com.good.food.domain.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebhookPedidoUseCaseImpl implements WebhookPedidoUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    @Override
    public Pedido execute(String idPedido) {
        final Pedido pedido = pedidoDatabaseGateway.findById(idPedido);
        pedido.setStatusPagamento(EStatusPagamentoPedido.PAGO);
        pedidoDatabaseGateway.save(pedido);

        return pedido;
    }
}
