package com.good.food.usecase.usecase.pedido;

import org.springframework.stereotype.Service;

import com.good.food.domain.entity.EStatusPagamentoPedido;
import com.good.food.domain.entity.Pedido;
import com.good.food.usecase.gateway.PedidoDatabaseGateway;
import com.good.food.usecase.presenter.PedidoPresenter;
import com.good.food.usecase.usecase.pedido.response.PedidoResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class WebhookPedidoUseCaseImpl implements WebhookPedidoUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;
    private final PedidoPresenter pedidoPresenter;

    @Override
    public PedidoResponse execute(String idPedido) {
        final Pedido pedido = pedidoDatabaseGateway.findById(idPedido);
        pedido.setStatusPagamento(EStatusPagamentoPedido.PAGO);
        pedidoDatabaseGateway.save(pedido);

        return pedidoPresenter.toResponse(pedido);
    }
}
