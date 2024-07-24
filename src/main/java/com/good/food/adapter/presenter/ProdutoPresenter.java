package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.response.ProdutoResponse;
import com.good.food.application.entity.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoPresenter {

    public ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto);
    }
}
