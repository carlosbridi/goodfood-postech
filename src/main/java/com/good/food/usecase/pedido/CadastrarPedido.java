package com.good.food.usecase.pedido;

import com.good.food.gateways.http.request.ItemPedidoRequest;
import com.good.food.usecase.cliente.BuscarCliente;
import com.good.food.usecase.produto.BuscarProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CadastrarPedido {

    @Autowired
    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    @Autowired
    private final BuscarCliente buscarCliente;

    @Autowired
    private final CadastrarItemPedido cadastrarItemPedido;

    public Pedido execute(final PedidoRequest pedidoRequest) {

        final Pedido pedido = pedidoRequest.toDomain();
        pedido.setCliente(buscarCliente.findByCpf(pedidoRequest.getClienteCPF()));

        pedidoRequest.getItemPedidos().forEach(itemPedidoRequest -> {
            pedido.addItem( cadastrarItemPedido.criarItemPedido(pedido, itemPedidoRequest));
        });

        return pedidoDatabaseGateway.save(pedido);
    }

}
