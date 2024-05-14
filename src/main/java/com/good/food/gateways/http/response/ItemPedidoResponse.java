package com.good.food.gateways.http.response;

import java.math.BigDecimal;
import com.good.food.domain.EProdutoCategoria;
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
  private BigDecimal preco;
  private EProdutoCategoria categoria;
  
  public ItemPedidoResponse(final ItemPedido itemPedido) {
    this.id = itemPedido.getId().toString();
    this.preco = itemPedido.getPreco();
    this.descricao = itemPedido.getProduto().getDescricao();
    this.categoria = itemPedido.getProduto().getCategoria();
  }
  
}
