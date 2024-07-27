package com.good.food.usecase.usecase.produto;

import com.good.food.domain.entity.Produto;


public interface BuscarProdutoUseCase {

  Produto execute(String uuid);

}
