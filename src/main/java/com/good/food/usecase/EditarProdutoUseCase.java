package com.good.food.usecase;

import java.util.UUID;
import com.good.food.domains.Produto;

public interface EditarProdutoUseCase {
  void execute(UUID produtoId, Produto produtoEditado);
}
