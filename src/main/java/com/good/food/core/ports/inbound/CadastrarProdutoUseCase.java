package com.good.food.core.ports.inbound;

import com.good.food.core.domain.Produto;

public interface CadastrarProdutoUseCase {

  Produto execute(Produto produto);
  
}
