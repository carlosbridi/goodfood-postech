package com.good.food.usecase.pedido;

import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import com.good.food.usecase.produto.BuscarProduto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdicionarAoPedido {

    @Autowired
    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    @Autowired
    private final BuscarProduto buscarProduto;
    @Autowired
    private final BuscarPedido buscarPedido;

    public Pedido execute(final String uuidPedido, final PedidoRequest pedidoRequest) {

        Pedido pedido = buscarPedido.execute(uuidPedido);

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
