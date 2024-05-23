package com.good.food.core.ports.inbound;

import java.util.UUID;
import com.good.food.core.domain.Produto;

public interface EditarProdutoUseCase {
  void execute(UUID produtoId, Produto produtoEditado);
}
