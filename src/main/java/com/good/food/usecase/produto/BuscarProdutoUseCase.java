package com.good.food.usecase.produto;

import com.good.food.domain.Produto;


public interface BuscarProdutoUseCase {

  Produto execute(String uuid);

}
