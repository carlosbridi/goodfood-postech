package com.good.food.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AlterarProduto {

  @Autowired
  private ProdutoDatabaseGateway produtoDatabaseGateway;
  
  public Produto execute(String id, Produto produto) {
    produtoDatabaseGateway.save(produto);
    return null;
  }
  
}
