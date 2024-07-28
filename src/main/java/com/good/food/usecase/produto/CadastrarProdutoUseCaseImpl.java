package com.good.food.usecase.produto;

import org.springframework.stereotype.Component;
import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
import com.good.food.adapter.presenter.ProdutoPresenter;
import com.good.food.domain.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarProdutoUseCaseImpl implements CadastrarProdutoUseCase {

    private final ProdutoDatabaseGateway produtoDatabaseGateway;
    private final ProdutoPresenter produtoPresenter;

    public Produto execute(Produto produto) {
        return produtoDatabaseGateway.save(produto);
    }

}
