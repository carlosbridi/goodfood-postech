package com.good.food.usecase.pedido;

import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import com.good.food.gateways.ItemPedidoDatabaseGateway;
import com.good.food.gateways.http.request.ItemPedidoRequest;
import com.good.food.usecase.produto.BuscarProduto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CadastrarItemPedido {

    @Autowired
    private final ItemPedidoDatabaseGateway itemPedidoDatabaseGateway;
    @Autowired
    private final BuscarProduto buscarProduto;

    public ItemPedido execute(ItemPedido itemPedido) {
        return itemPedidoDatabaseGateway.save(itemPedido);
    }


    protected ItemPedido criarItemPedido(final Pedido pedido, final ItemPedidoRequest itemPedidoRequest) {
        final Produto produto = buscarProduto.execute(itemPedidoRequest.getProdutoUUID());

        final ItemPedido itemPedido = itemPedidoRequest.toDomain();
        itemPedido.setProduto(produto);
        itemPedido.setPreco(produto.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade())));
        itemPedido.setPedido(pedido);
        //cadastrarItemPedido.execute(itemPedido);
        return itemPedido;

    }
}
