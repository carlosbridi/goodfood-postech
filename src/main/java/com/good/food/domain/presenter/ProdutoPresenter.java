package com.good.food.domain.presenter;

import com.good.food.domain.usecase.produto.response.ProdutoResponse;
import com.good.food.domain.entity.Produto;

public interface ProdutoPresenter {

    ProdutoResponse toResponse(Produto produto);
}
