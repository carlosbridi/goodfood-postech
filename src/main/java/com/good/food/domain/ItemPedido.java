package com.good.food.domain;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemPedido {

  private UUID id;
  private UUID pedido;
  private String produtoId;
  private Produto produto;
  private String observacoes;
  private Integer quantidade;
  private BigDecimal preco;
  
  public BigDecimal obterTotalItem() {
    return preco.multiply(new BigDecimal(quantidade));
  }
  
}
