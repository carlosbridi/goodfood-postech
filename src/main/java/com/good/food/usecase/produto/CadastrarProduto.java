package com.good.food.usecase.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarProduto {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public Produto execute(Produto produto) {
    return produtoDatabaseGateway.save(produto);
  }
  
}
