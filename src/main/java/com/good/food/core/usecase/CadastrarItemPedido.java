package com.good.food.core.usecase;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.adapter.inbound.controller.request.ItemPedidoRequest;
import com.good.food.core.domain.ItemPedido;
import com.good.food.core.domain.Pedido;
import com.good.food.core.domain.Produto;
import com.good.food.core.ports.inbound.BuscarProdutoUseCase;
import com.good.food.core.ports.inbound.CadastrarItemPedidoUseCase;
import com.good.food.core.ports.outbound.ItemPedidoDatabaseGateway;
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
