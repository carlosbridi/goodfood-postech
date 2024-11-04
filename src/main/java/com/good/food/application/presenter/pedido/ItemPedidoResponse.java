package com.good.food.application.presenter.pedido;

import java.math.BigDecimal;
import com.good.food.domain.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoResponse {

  private String id;
  private String descricao;
  private String observacoes;
  private int quantidade;
  private BigDecimal preco;
  private String categoria;
  
  public ItemPedidoResponse(final ItemPedido itemPedido) {
    this.id = itemPedido.getId().toString();
    this.preco = itemPedido.getPreco();    
    this.descricao = itemPedido.getDescricaoItem();
    this.categoria = itemPedido.getCategoria();    
    this.observacoes = itemPedido.getObservacoes();
    this.quantidade = itemPedido.getQuantidade();
  }
  
}
