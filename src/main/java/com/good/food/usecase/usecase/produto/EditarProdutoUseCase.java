package com.good.food.usecase.usecase.produto;

import java.util.UUID;

import com.good.food.usecase.usecase.produto.request.ProdutoRequest;

public interface EditarProdutoUseCase {
  void execute(UUID id, ProdutoRequest produtoRequest);
}
