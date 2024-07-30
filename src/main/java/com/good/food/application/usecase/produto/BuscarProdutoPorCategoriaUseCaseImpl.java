package com.good.food.application.usecase.produto;

import java.util.List;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarProdutoPorCategoriaUseCaseImpl implements BuscarProdutoPorCategoriaUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;
  
  @Override
  public List<Produto> execute(String categoria) {
    return produtoDatabaseGateway.findByCategory(categoria);
  }
}
