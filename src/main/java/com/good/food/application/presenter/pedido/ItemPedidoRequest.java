package com.good.food.application.presenter.pedido;

import com.good.food.domain.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoRequest {

  private String produtoUUID;
  private String observacoes;
  private int quantidade;

  public ItemPedido toDomain() {
    return ItemPedido.builder().produtoId(produtoUUID).observacoes(observacoes).quantidade(quantidade).build();
  }
}
