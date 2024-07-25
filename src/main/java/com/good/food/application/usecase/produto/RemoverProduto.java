package com.good.food.application.usecase.produto;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class RemoverProduto implements RemoverProdutoUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  @Override
  public void execute(UUID produtoId) {
    //check if has using on products before delete
    produtoDatabaseGateway.delete(produtoId);
  }
  
}
