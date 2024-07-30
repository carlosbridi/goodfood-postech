package com.good.food.application.usecase.produto;

import java.util.UUID;

import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;

public class EditarProdutoUseCaseImpl implements EditarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  public EditarProdutoUseCaseImpl(ProdutoDatabaseGateway produtoDatabaseGateway) {
    this.produtoDatabaseGateway = produtoDatabaseGateway;
  }

  public void execute(UUID id, Produto produtoEdited) {
    Produto produto = produtoDatabaseGateway.findById(id);
    
    produto.setPreco(produtoEdited.getPreco());
    produto.setDescricao(produtoEdited.getDescricao());
    produto.setCategoria(produtoEdited.getCategoria());
    
    produtoDatabaseGateway.save(produto);
  }
  
}
