package com.good.food.application.usecase.pedido;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.ItemPedidoDatabaseGateway;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import com.good.food.application.usecase.produto.BuscarProdutoUseCase;
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
      final ItemPedido itemPedido) {
    final Produto produto = buscarProduto.execute(itemPedido.getProdutoId());

    itemPedido.setProduto(produto);
    itemPedido
        .setPreco(produto.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade())));
    itemPedido.setPedido(pedido.getId());
    return itemPedidoDatabaseGateway.save(itemPedido);
  }
}
