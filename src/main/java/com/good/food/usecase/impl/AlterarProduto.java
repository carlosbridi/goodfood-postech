package com.good.food.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import com.good.food.usecase.AlterarProdutoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AlterarProduto implements AlterarProdutoUseCase {

  @Autowired
  private ProdutoDatabaseGateway produtoDatabaseGateway;
  
  public Produto execute(String id, Produto produto) {
    produtoDatabaseGateway.save(produto);
    return null;
  }
  
}
