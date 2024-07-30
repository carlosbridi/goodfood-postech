package com.good.food.application.usecase.produto;

import java.util.UUID;

import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;

public class BuscarProdutoUseCaseImpl implements BuscarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  public BuscarProdutoUseCaseImpl(ProdutoDatabaseGateway produtoDatabaseGateway) {
    this.produtoDatabaseGateway = produtoDatabaseGateway;
  }

  @Override
  public Produto execute(String uuid) {
    return produtoDatabaseGateway.findById(UUID.fromString(uuid));
  }
}
