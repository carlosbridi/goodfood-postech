package com.good.food.application.usecase.produto;

import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.application.presenter.produto.ProdutoPresenter;
import com.good.food.domain.Produto;

public class CadastrarProdutoUseCaseImpl implements CadastrarProdutoUseCase {

    private final ProdutoDatabaseGateway produtoDatabaseGateway;
    private final ProdutoPresenter produtoPresenter;

    public CadastrarProdutoUseCaseImpl(ProdutoDatabaseGateway produtoDatabaseGateway, ProdutoPresenter produtoPresenter) {
        this.produtoDatabaseGateway = produtoDatabaseGateway;
        this.produtoPresenter = produtoPresenter;
    }

    public Produto execute(Produto produto) {
        return produtoDatabaseGateway.save(produto);
    }

}
