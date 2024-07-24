package com.good.food.application.usecase;

import com.good.food.application.entity.Produto;


public interface BuscarProdutoUseCase {

  Produto execute(String uuid);

}
