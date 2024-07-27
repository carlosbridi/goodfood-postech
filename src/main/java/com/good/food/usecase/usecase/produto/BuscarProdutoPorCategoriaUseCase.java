package com.good.food.usecase.usecase.produto;

import java.util.List;

import com.good.food.usecase.usecase.produto.response.ProdutoResponse;

public interface BuscarProdutoPorCategoriaUseCase {

    List<ProdutoResponse> execute(String categoria);
}
