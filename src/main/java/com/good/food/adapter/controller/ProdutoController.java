package com.good.food.adapter.controller;

import java.util.List;

import com.good.food.application.presenter.produto.ProdutoRequest;
import com.good.food.application.presenter.produto.ProdutoResponse;

public interface ProdutoController {

    ProdutoResponse cadastrarProduto(ProdutoRequest produtoRequest);

    void editarProduto(ProdutoRequest produtoRequest);

    List<ProdutoResponse> buscarPorCategoria(String categoria);

    void removerProduto(String id);
}
