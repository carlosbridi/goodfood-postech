package com.good.food.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Produto;
import com.good.food.application.usecase.AlterarProdutoUseCase;
import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
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
