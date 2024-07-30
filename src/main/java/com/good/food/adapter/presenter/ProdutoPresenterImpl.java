package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;
import com.good.food.application.presenter.produto.ProdutoResponse;
import com.good.food.application.presenter.produto.ProdutoPresenter;
import com.good.food.domain.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoPresenterImpl implements ProdutoPresenter {

    @Override
    public ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto);
    }
}
