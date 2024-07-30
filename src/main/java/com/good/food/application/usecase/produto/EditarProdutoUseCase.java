package com.good.food.application.usecase.produto;

import java.util.UUID;

import com.good.food.domain.Produto;

public interface EditarProdutoUseCase {
  void execute(UUID id, Produto produto);
}
