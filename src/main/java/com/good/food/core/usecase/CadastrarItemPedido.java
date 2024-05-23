package com.good.food.core.usecase;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import com.good.food.gateways.ItemPedidoDatabaseGateway;
import com.good.food.gateways.http.request.ItemPedidoRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarItemPedido {

  private final BuscarProduto buscarProduto;
  private final ItemPedidoDatabaseGateway itemPedidoDatabaseGateway;

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
