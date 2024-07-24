package com.good.food.application.usecase.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.adapter.controller.request.ItemPedidoRequest;
import com.good.food.application.entity.ItemPedido;
import com.good.food.application.entity.Pedido;
import com.good.food.application.entity.Produto;
import com.good.food.application.usecase.BuscarProdutoUseCase;
import com.good.food.application.usecase.CadastrarItemPedidoUseCase;
import com.good.food.adapter.gateway.ItemPedidoDatabaseGateway;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarItemPedido implements CadastrarItemPedidoUseCase {

  private final BuscarProdutoUseCase buscarProduto;
  private final ItemPedidoDatabaseGateway itemPedidoDatabaseGateway;

  @Override
  @Transactional
  public ItemPedido execute(final Pedido pedido,
      final ItemPedidoRequest itemPedidoRequest) {
    final Produto produto = buscarProduto.execute(itemPedidoRequest.getProdutoUUID());

    final ItemPedido itemPedido = itemPedidoRequest.toDomain();
    itemPedido.setProduto(produto);
    itemPedido
        .setPreco(produto.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade())));
    itemPedido.setPedido(pedido);
    return itemPedidoDatabaseGateway.save(itemPedido);
  }
}
