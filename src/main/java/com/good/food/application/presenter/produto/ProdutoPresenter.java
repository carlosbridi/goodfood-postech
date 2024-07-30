package com.good.food.application.presenter.produto;

import com.good.food.domain.Produto;

public interface ProdutoPresenter {

    ProdutoResponse toResponse(Produto produto);
}
