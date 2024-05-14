package com.good.food.usecase.pedido;

import com.good.food.usecase.cliente.BuscarCliente;
import com.good.food.usecase.produto.BuscarProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarPedido {

    @Autowired
    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    @Autowired
    private final BuscarCliente buscarCliente;
    @Autowired
    private final BuscarProduto buscarProduto;

    public Pedido execute(final PedidoRequest pedidoRequest) {

        final Pedido pedido = pedidoRequest.toDomain();
        pedido.setCliente(buscarCliente.findByCpf(pedidoRequest.getClienteCPF()));

        pedidoRequest.getProdutosUUID().forEach(produtoId -> {
            pedido.addItem( criarItemPedido(pedido, produtoId));
        });

        return pedidoDatabaseGateway.save(pedido);
    }

    private ItemPedido criarItemPedido(final Pedido pedido, final String itemPedidoId) {
        final Produto produto = buscarProduto.execute(itemPedidoId);

        final ItemPedido itemPedido = new ItemPedido();
        itemPedido.setProduto(produto);
        itemPedido.setPreco(produto.getPreco());
        itemPedido.setPedido(pedido);

        return itemPedido;
    }

}
