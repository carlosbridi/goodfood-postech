package com.good.food.domain.usecase.pedido;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.Pedido;
import com.good.food.domain.gateway.ClienteDatabaseGateway;
import com.good.food.domain.gateway.PedidoDatabaseGateway;
import com.good.food.domain.presenter.PedidoPresenter;
import com.good.food.domain.usecase.cliente.BuscarClienteUseCase;
import com.good.food.domain.usecase.pedido.request.PedidoRequest;
import com.good.food.domain.usecase.pedido.response.PedidoResponse;
import jakarta.transaction.Transactional;

@Component
class CadastrarPedidoUseCaseImpl implements CadastrarPedidoUseCase {

    private PedidoDatabaseGateway pedidoDatabaseGateway;
    private BuscarClienteUseCase buscarCliente;
    private CadastrarItemPedidoUseCase cadastrarItemPedido;
    private PedidoPresenter pedidoPresenter;
    private ClienteDatabaseGateway clienteDatabaseGateway;

    @Override
    @Transactional
    public PedidoResponse execute(final PedidoRequest pedidoRequest) {
        final Pedido pedido = pedidoRequest.toDomain();
        pedido.setCliente(clienteDatabaseGateway.findByCpf(pedidoRequest.getClienteCPF()));

        // useCase futuro pra pagamento
        pedido.setStatus("RECEBIDO");

        final Pedido pedidoSaved = pedidoDatabaseGateway.save(pedido);

        pedidoRequest.getItemPedidos().forEach(itemPedidoRequest -> {
            pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
        });

        return pedidoPresenter.toResponse(pedidoSaved);
    }

}
