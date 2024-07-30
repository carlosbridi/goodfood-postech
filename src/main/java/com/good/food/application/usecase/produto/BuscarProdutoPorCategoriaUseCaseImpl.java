package com.good.food.application.usecase.produto;

import java.util.List;

import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;

public class BuscarProdutoPorCategoriaUseCaseImpl implements BuscarProdutoPorCategoriaUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  public BuscarProdutoPorCategoriaUseCaseImpl(ProdutoDatabaseGateway produtoDatabaseGateway) {
    this.produtoDatabaseGateway = produtoDatabaseGateway;
  }

  @Override
  public List<Produto> execute(String categoria) {
    return produtoDatabaseGateway.findByCategory(categoria);
  }
}
