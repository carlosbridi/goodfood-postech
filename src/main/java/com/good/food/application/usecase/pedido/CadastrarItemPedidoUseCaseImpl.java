package com.good.food.application.usecase.pedido;

import java.math.BigDecimal;

import com.good.food.application.gateway.ItemPedidoDatabaseGateway;
import com.good.food.application.usecase.produto.BuscarProdutoUseCase;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import jakarta.transaction.Transactional;

public class CadastrarItemPedidoUseCaseImpl implements CadastrarItemPedidoUseCase {

  private final ItemPedidoDatabaseGateway itemPedidoDatabaseGateway;
  private final BuscarProdutoUseCase buscarProduto;

  public CadastrarItemPedidoUseCaseImpl(ItemPedidoDatabaseGateway itemPedidoDatabaseGateway, BuscarProdutoUseCase buscarProduto) {
    this.itemPedidoDatabaseGateway = itemPedidoDatabaseGateway;
    this.buscarProduto = buscarProduto;
  }

  @Override
  @Transactional
  public ItemPedido execute(final Pedido pedido,
      final ItemPedido itemPedido) {
    final Produto produto = buscarProduto.execute(itemPedido.getProdutoId());

    itemPedido.setProduto(produto);
    itemPedido
        .setPreco(produto.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade())));
    itemPedido.setPedido(pedido.getId());
    return itemPedidoDatabaseGateway.save(itemPedido);
  }
}
