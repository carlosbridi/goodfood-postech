package com.good.food.usecase.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class AlterarProdutoUseCaseImpl implements AlterarProdutoUseCase {

  @Autowired
  private ProdutoDatabaseGateway produtoDatabaseGateway;
  
  public Produto execute(String id, Produto produto) {
    produtoDatabaseGateway.save(produto);
    return null;
  }
  
}
