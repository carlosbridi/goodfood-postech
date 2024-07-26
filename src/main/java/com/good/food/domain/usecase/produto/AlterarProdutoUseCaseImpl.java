package com.good.food.domain.usecase.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.entity.Produto;
import com.good.food.domain.gateway.ProdutoDatabaseGateway;
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
