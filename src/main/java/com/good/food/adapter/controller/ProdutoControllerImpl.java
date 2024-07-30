package com.good.food.adapter.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.good.food.application.presenter.produto.ProdutoRequest;
import com.good.food.application.presenter.produto.ProdutoResponse;
import com.good.food.application.presenter.produto.ProdutoPresenter;
import com.good.food.domain.Produto;
import com.good.food.application.usecase.produto.BuscarProdutoPorCategoriaUseCase;
import com.good.food.application.usecase.produto.CadastrarProdutoUseCase;
import com.good.food.application.usecase.produto.EditarProdutoUseCase;
import com.good.food.application.usecase.produto.RemoverProdutoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoControllerImpl implements ProdutoController {

  private final CadastrarProdutoUseCase cadastrarProduto;
  private final RemoverProdutoUseCase removerProduto;
  private final EditarProdutoUseCase editarProduto;
  private final BuscarProdutoPorCategoriaUseCase buscarProdutoPorCategoria;

  private final ProdutoPresenter produtoPresenter;
  
  @Override
  public ProdutoResponse cadastrarProduto(ProdutoRequest produtoRequest) {
    return produtoPresenter.toResponse(cadastrarProduto.execute(produtoRequest.toDomain()));
  }
  
  @Override
  public void editarProduto(ProdutoRequest produtoRequest) {
    final Produto produto = produtoRequest.toDomain();
    editarProduto.execute(produto.getId(), produto); 
  }
  
  @Override
  public List<ProdutoResponse> buscarPorCategoria(String categoria){
    return buscarProdutoPorCategoria.execute(categoria)
        .stream().map(prd -> produtoPresenter.toResponse(prd))
        .collect(Collectors.toList());
  }
  
  @Override
  public void removerProduto(String id) {
    removerProduto.execute(UUID.fromString(id));
  }
  
}
