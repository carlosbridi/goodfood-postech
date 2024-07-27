package com.good.food.usecase.pedido;

import org.springframework.stereotype.Component;
import com.good.food.adapter.ClienteDatabaseGateway;
import com.good.food.adapter.PedidoDatabaseGateway;
import com.good.food.adapter.PedidoPresenter;
import com.good.food.adapter.controller.web.request.pedido.PedidoRequest;
import com.good.food.adapter.controller.web.response.pedido.PedidoResponse;
import com.good.food.domain.EStatusPagamentoPedido;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.Pedido;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarPedidoUseCaseImpl implements CadastrarPedidoUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;
    private final CadastrarItemPedidoUseCase cadastrarItemPedido;
    private final PedidoPresenter pedidoPresenter;
    private final ClienteDatabaseGateway clienteDatabaseGateway;

    
    //analisar
    @Override
    @Transactional
    public Pedido execute(final Pedido newPedido, final String clienteCpf) {
        newPedido.setCliente(clienteDatabaseGateway.findByCpf(clienteCpf));

        newPedido.setStatus(EStatusPedido.RECEBIDO);
        newPedido.setStatusPagamento(EStatusPagamentoPedido.PENDENTE);

        final Pedido pedidoSaved = pedidoDatabaseGateway.save(newPedido);

        newPedido.getItemPedido().forEach(itemPedidoRequest -> {
            pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
        });

        // TODO pagamento fake

        return pedidoSaved;
    }

}
