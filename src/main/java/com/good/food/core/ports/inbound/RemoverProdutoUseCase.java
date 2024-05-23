package com.good.food.core.ports.inbound;

import java.util.UUID;


public interface RemoverProdutoUseCase {

  void execute(UUID produtoId);

}
