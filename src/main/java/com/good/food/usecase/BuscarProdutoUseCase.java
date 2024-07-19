package com.good.food.usecase;

import com.good.food.domains.Produto;


public interface BuscarProdutoUseCase {

  Produto execute(String uuid);

}
