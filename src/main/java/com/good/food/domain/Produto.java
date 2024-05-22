package com.good.food.domain;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Produto {
  
  private String id;
  private String descricao;
  private BigDecimal preco;
  private String categoria;
  
}
