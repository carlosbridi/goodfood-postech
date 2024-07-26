package com.good.food.domain.usecase.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.good.food.domain.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.presenter.ProdutoPresenter;
import com.good.food.domain.usecase.produto.response.ProdutoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarProdutoPorCategoria implements BuscarProdutoPorCategoriaUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;
  private final ProdutoPresenter produtoPresenter;
  
  @Override
  public List<ProdutoResponse> execute(String categoria) {
    return produtoDatabaseGateway.findByCategory(categoria).stream().map(produtoPresenter::toResponse).collect(Collectors.toList());
  }
}
