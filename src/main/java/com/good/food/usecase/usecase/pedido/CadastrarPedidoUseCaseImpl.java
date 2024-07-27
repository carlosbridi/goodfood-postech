package com.good.food.usecase.usecase.pedido;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.EStatusPagamentoPedido;
import com.good.food.domain.entity.EStatusPedido;
import com.good.food.domain.entity.Pedido;
import com.good.food.usecase.gateway.ClienteDatabaseGateway;
import com.good.food.usecase.gateway.PedidoDatabaseGateway;
import com.good.food.usecase.presenter.PedidoPresenter;
import com.good.food.usecase.usecase.pedido.request.PedidoRequest;
import com.good.food.usecase.usecase.pedido.response.PedidoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarPedidoUseCaseImpl implements CadastrarPedidoUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;
    private final CadastrarItemPedidoUseCase cadastrarItemPedido;
    private final PedidoPresenter pedidoPresenter;
    private final ClienteDatabaseGateway clienteDatabaseGateway;

    @Override
    @Transactional
    public PedidoResponse execute(final PedidoRequest pedidoRequest) {
        final Pedido pedido = pedidoRequest.toDomain();
        pedido.setCliente(clienteDatabaseGateway.findByCpf(pedidoRequest.getClienteCPF()));

        pedido.setStatus(EStatusPedido.RECEBIDO);
        pedido.setStatusPagamento(EStatusPagamentoPedido.PENDENTE);

        final Pedido pedidoSaved = pedidoDatabaseGateway.save(pedido);

        pedidoRequest.getItemPedidos().forEach(itemPedidoRequest -> {
            pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
        });

        // TODO pagamento fake

        return pedidoPresenter.toResponse(pedidoSaved);
    }

}
