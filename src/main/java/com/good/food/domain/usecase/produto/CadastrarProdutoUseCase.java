package com.good.food.domain.usecase.produto;

import com.good.food.domain.usecase.produto.request.ProdutoRequest;
import com.good.food.domain.usecase.produto.response.ProdutoResponse;

public interface CadastrarProdutoUseCase {

  ProdutoResponse execute(ProdutoRequest produtoRequest);
  
}
