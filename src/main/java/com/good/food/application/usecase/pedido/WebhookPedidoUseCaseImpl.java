package com.good.food.application.usecase.pedido;

import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPagamentoPedido;
import com.good.food.domain.Pedido;

public class WebhookPedidoUseCaseImpl implements WebhookPedidoUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    public WebhookPedidoUseCaseImpl(PedidoDatabaseGateway pedidoDatabaseGateway) {
        this.pedidoDatabaseGateway = pedidoDatabaseGateway;
    }

    @Override
    public Pedido execute(String idPedido) {
        final Pedido pedido = pedidoDatabaseGateway.findById(idPedido);
        pedido.setStatusPagamento(EStatusPagamentoPedido.PAGO);
        pedidoDatabaseGateway.save(pedido);

        return pedido;
    }
}
