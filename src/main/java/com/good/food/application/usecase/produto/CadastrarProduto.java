package com.good.food.application.usecase.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Produto;
import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarProduto implements CadastrarProdutoUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public Produto execute(Produto produto) {
    return produtoDatabaseGateway.save(produto);
  }
  
}
