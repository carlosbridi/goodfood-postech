package com.good.food.usecase.usecase.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.good.food.usecase.gateway.ProdutoDatabaseGateway;
import com.good.food.usecase.presenter.ProdutoPresenter;
import com.good.food.usecase.usecase.produto.response.ProdutoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarProdutoPorCategoriaUseCaseImpl implements BuscarProdutoPorCategoriaUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;
  private final ProdutoPresenter produtoPresenter;
  
  @Override
  public List<ProdutoResponse> execute(String categoria) {
    return produtoDatabaseGateway.findByCategory(categoria).stream().map(produtoPresenter::toResponse).collect(Collectors.toList());
  }
}
