package com.good.food.application.usecase.produto;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.good.food.application.gateway.ProdutoDatabaseGateway;

public class RemoverProdutoUseCaseImpl implements RemoverProdutoUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  public RemoverProdutoUseCaseImpl(ProdutoDatabaseGateway produtoDatabaseGateway) {
    this.produtoDatabaseGateway = produtoDatabaseGateway;
  }

  @Override
  public void execute(UUID produtoId) {
    //check if has using on products before delete
    produtoDatabaseGateway.delete(produtoId);
  }
  
}
