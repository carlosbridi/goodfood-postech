package com.good.food.application.usecase.produto;

import java.util.List;

import com.good.food.domain.Produto;

public interface BuscarProdutoPorCategoriaUseCase {

    List<Produto> execute(String categoria);
}
