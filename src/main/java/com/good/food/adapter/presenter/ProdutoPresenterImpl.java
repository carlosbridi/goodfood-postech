package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.domain.usecase.produto.response.ProdutoResponse;
import com.good.food.domain.entity.Produto;
import com.good.food.domain.presenter.ProdutoPresenter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoPresenterImpl implements ProdutoPresenter {

    @Override
    public ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto);
    }
}
