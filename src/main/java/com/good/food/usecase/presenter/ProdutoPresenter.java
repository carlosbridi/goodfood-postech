package com.good.food.usecase.presenter;

import com.good.food.usecase.usecase.produto.response.ProdutoResponse;
import com.good.food.domain.entity.Produto;

public interface ProdutoPresenter {

    ProdutoResponse toResponse(Produto produto);
}
