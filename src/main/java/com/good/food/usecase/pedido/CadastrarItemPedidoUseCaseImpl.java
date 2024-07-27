package com.good.food.usecase.pedido;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.adapter.ItemPedidoDatabaseGateway;
import com.good.food.adapter.controller.web.request.pedido.ItemPedidoRequest;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import com.good.food.usecase.produto.BuscarProdutoUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarItemPedidoUseCaseImpl implements CadastrarItemPedidoUseCase {

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
    itemPedido.setPedido(pedido.getId());
    return itemPedidoDatabaseGateway.save(itemPedido);
  }
}
