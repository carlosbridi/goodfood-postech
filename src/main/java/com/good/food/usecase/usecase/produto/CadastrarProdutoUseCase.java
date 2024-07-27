package com.good.food.usecase.usecase.produto;

import com.good.food.usecase.usecase.produto.request.ProdutoRequest;
import com.good.food.usecase.usecase.produto.response.ProdutoResponse;

public interface CadastrarProdutoUseCase {

  ProdutoResponse execute(ProdutoRequest produtoRequest);
  
}
