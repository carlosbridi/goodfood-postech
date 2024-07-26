package com.good.food.domain.usecase.produto;

import com.good.food.domain.entity.Produto;


public interface BuscarProdutoUseCase {

  Produto execute(String uuid);

}
