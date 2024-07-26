package com.good.food.domain.usecase.produto;

import java.util.List;

import com.good.food.domain.usecase.produto.response.ProdutoResponse;

public interface BuscarProdutoPorCategoriaUseCase {

    List<ProdutoResponse> execute(String categoria);
}
