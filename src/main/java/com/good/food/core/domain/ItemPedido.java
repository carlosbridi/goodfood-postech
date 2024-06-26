package com.good.food.core.domain;

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
  private Pedido pedido;
  private Produto produto;
  private String observacoes;
  private Integer quantidade;
  private BigDecimal preco;
  
}
