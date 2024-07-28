package com.good.food.usecase.pedido;

import java.util.List;
import org.springframework.stereotype.Component;
import com.good.food.adapter.gateway.ClienteDatabaseGateway;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPagamentoPedido;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarPedidoUseCaseImpl implements CadastrarPedidoUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;
    private final CadastrarItemPedidoUseCase cadastrarItemPedido;
    private final ClienteDatabaseGateway clienteDatabaseGateway;

    @Override
    @Transactional
    public Pedido execute(final Pedido newPedido, List<ItemPedido> itensPedido, final String clienteCpf) {
        newPedido.setCliente(clienteDatabaseGateway.findByCpf(clienteCpf));

        newPedido.setStatus(EStatusPedido.RECEBIDO);
        newPedido.setStatusPagamento(EStatusPagamentoPedido.PENDENTE);

        final Pedido pedidoSaved = pedidoDatabaseGateway.save(newPedido);

        itensPedido.forEach(itemPedidoRequest -> {
            pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
        });

        // TODO pagamento fake

        return pedidoSaved;
    }

}
