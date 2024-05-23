package com.good.food.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Produto;
import com.good.food.core.ports.inbound.CadastrarProdutoUseCase;
import com.good.food.core.ports.outbound.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarProduto implements CadastrarProdutoUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public Produto execute(Produto produto) {
    return produtoDatabaseGateway.save(produto);
  }
  
}
