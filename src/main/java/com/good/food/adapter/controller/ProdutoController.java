package com.good.food.adapter.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.request.ProdutoRequest;
import com.good.food.adapter.controller.response.ProdutoResponse;
import com.good.food.adapter.presenter.ProdutoPresenter;
import com.good.food.application.entity.Produto;
import com.good.food.application.usecase.CadastrarProdutoUseCase;
import com.good.food.application.usecase.EditarProdutoUseCase;
import com.good.food.application.usecase.RemoverProdutoUseCase;
import com.good.food.application.usecase.impl.BuscarProdutoPorCategoria;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoController {

    private final CadastrarProdutoUseCase cadastrarProduto;
    private final RemoverProdutoUseCase removerProduto;
    private final EditarProdutoUseCase editarProduto;
    private final BuscarProdutoPorCategoria buscarProdutoPorCategoria;
    private final ProdutoPresenter produtoPresenter;

    public ProdutoResponse cadastrarProduto(ProdutoRequest produtoRequest) {
        Produto produto = cadastrarProduto.execute(produtoRequest.toDomain());
        return produtoPresenter.toResponse(produto);
    }

    public void editarProduto(UUID id, ProdutoRequest produtoRequest) {
        editarProduto.execute(id, produtoRequest.toDomain());
    }

    public List<ProdutoResponse> buscarPorCategoria(String categoria) {
        List<Produto> produtos = buscarProdutoPorCategoria.execute(categoria);
        return produtos.stream().map(produtoPresenter::toResponse).collect(Collectors.toList());
    }

    public void removerProduto(UUID produtoId) {
        removerProduto.execute(produtoId);
    }
}
