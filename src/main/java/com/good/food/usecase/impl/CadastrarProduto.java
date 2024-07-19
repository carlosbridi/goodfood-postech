package com.good.food.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import com.good.food.usecase.CadastrarProdutoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarProduto implements CadastrarProdutoUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public Produto execute(Produto produto) {
    return produtoDatabaseGateway.save(produto);
  }
  
}
