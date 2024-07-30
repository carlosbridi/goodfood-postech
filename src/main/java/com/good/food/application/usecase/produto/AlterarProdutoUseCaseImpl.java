package com.good.food.application.usecase.produto;

import org.springframework.beans.factory.annotation.Autowired;

import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;

public class AlterarProdutoUseCaseImpl implements AlterarProdutoUseCase {

  @Autowired
  private ProdutoDatabaseGateway produtoDatabaseGateway;

  public AlterarProdutoUseCaseImpl(ProdutoDatabaseGateway produtoDatabaseGateway) {
    this.produtoDatabaseGateway = produtoDatabaseGateway;
  }

  public Produto execute(String id, Produto produto) {
    produtoDatabaseGateway.save(produto);
    return null;
  }
  
}
