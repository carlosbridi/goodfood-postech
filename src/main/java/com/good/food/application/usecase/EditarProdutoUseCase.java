package com.good.food.application.usecase;

import java.util.UUID;
import com.good.food.application.entity.Produto;

public interface EditarProdutoUseCase {
  void execute(UUID produtoId, Produto produtoEditado);
}
