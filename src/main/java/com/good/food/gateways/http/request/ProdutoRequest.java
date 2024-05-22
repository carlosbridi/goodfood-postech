package com.good.food.gateways.http.request;

import java.io.Serializable;
import java.math.BigDecimal;
import com.good.food.core.entity.EProdutoCategoria;
import com.good.food.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest implements Serializable {

  private static final long serialVersionUID = 8052492168210242514L;
  
  private String descricao;
  private BigDecimal preco;
  private String categoria;
  
  public Produto toDomain() {
    return Produto.builder()
        .descricao(descricao)
        .preco(preco)        
        .categoria(categoria)
      .build();
  }
  
}
