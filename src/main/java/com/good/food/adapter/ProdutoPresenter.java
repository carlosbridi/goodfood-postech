package com.good.food.adapter;

import com.good.food.adapter.controller.web.response.produto.ProdutoResponse;
import com.good.food.domain.Produto;

public interface ProdutoPresenter {

    ProdutoResponse toResponse(Produto produto);
}
