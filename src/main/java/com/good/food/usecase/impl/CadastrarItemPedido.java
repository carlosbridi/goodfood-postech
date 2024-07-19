package com.good.food.usecase.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.domains.ItemPedido;
import com.good.food.domains.Pedido;
import com.good.food.domains.Produto;
import com.good.food.gateways.ItemPedidoDatabaseGateway;
import com.good.food.gateways.api.request.ItemPedidoRequest;
import com.good.food.usecase.BuscarProdutoUseCase;
import com.good.food.usecase.CadastrarItemPedidoUseCase;
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
