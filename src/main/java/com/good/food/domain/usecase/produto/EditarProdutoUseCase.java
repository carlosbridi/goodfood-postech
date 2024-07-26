package com.good.food.domain.usecase.produto;

import java.util.UUID;

import com.good.food.domain.usecase.produto.request.ProdutoRequest;

public interface EditarProdutoUseCase {
  void execute(UUID id, ProdutoRequest produtoRequest);
}
