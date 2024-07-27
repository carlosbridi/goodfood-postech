package com.good.food.usecase.usecase.produto;

import org.springframework.stereotype.Component;

import com.good.food.usecase.gateway.ProdutoDatabaseGateway;
import com.good.food.usecase.presenter.ProdutoPresenter;
import com.good.food.usecase.usecase.produto.request.ProdutoRequest;
import com.good.food.usecase.usecase.produto.response.ProdutoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarProdutoUseCaseImpl implements CadastrarProdutoUseCase {

    private final ProdutoDatabaseGateway produtoDatabaseGateway;
    private final ProdutoPresenter produtoPresenter;

    public ProdutoResponse execute(ProdutoRequest produtoRequest) {
        return produtoPresenter.toResponse(produtoDatabaseGateway.save(produtoRequest.toDomain()));
    }

}
