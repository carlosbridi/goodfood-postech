package com.good.food.core.ports.inbound;

import com.good.food.core.domain.Produto;


public interface BuscarProdutoUseCase {

  Produto execute(String uuid);

}
