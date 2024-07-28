package com.good.food.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.good.food.adapter.controller.web.request.produto.ProdutoRequest;
import com.good.food.adapter.controller.web.response.produto.ProdutoResponse;
import com.good.food.adapter.presenter.ProdutoPresenter;
import com.good.food.domain.Produto;
import com.good.food.usecase.produto.BuscarProdutoPorCategoriaUseCase;
import com.good.food.usecase.produto.CadastrarProdutoUseCase;
import com.good.food.usecase.produto.EditarProdutoUseCase;
import com.good.food.usecase.produto.RemoverProdutoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoController {

  private final CadastrarProdutoUseCase cadastrarProduto;
  private final RemoverProdutoUseCase removerProduto;
  private final EditarProdutoUseCase editarProduto;
  private final BuscarProdutoPorCategoriaUseCase buscarProdutoPorCategoria;

  private final ProdutoPresenter produtoPresenter;
  
  public ProdutoResponse cadastrarProduto(ProdutoRequest produtoRequest) {
    return produtoPresenter.toResponse(cadastrarProduto.execute(produtoRequest.toDomain()));
  }
  
  public void editarProduto(ProdutoRequest produtoRequest) {
    final Produto produto = produtoRequest.toDomain();
    editarProduto.execute(produto.getId(), produto); 
  }
  
  public List<ProdutoResponse> buscarPorCategoria(String categoria){
    return buscarProdutoPorCategoria.execute(categoria)
        .stream().map(prd -> produtoPresenter.toResponse(prd))
        .collect(Collectors.toList());
  }
  
  public void removerProduto(String id) {
    removerProduto.execute(UUID.fromString(id));
  }
  
}
