package com.good.food.application.usecase.produto;

import com.good.food.application.entity.Produto;


public interface BuscarProdutoUseCase {

  Produto execute(String uuid);

}
