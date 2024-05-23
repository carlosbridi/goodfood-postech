package com.good.food.adapter.inbound.controller.response;

import java.io.Serializable;
import java.math.BigDecimal;
import com.good.food.core.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse implements Serializable {

  private static final long serialVersionUID = 5033384337768652970L;
  
  private String uuid;
  private String descricao;
  private BigDecimal preco;
  
  public ProdutoResponse(final Produto produto) {
    this.uuid = produto.getId().toString();
    this.descricao = produto.getDescricao();        
    this.preco = produto.getPreco();
  }

}
