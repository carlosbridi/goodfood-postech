package com.good.food.usecase.usecase.produto;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.Produto;
import com.good.food.usecase.gateway.ProdutoDatabaseGateway;
import com.good.food.usecase.usecase.produto.request.ProdutoRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EditarProdutoUseCaseImpl implements EditarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;
  
  public void execute(UUID id, ProdutoRequest produtoRequest) {
    Produto produto = produtoDatabaseGateway.findById(id);
    
    produto.setPreco(produtoRequest.getPreco());
    produto.setDescricao(produtoRequest.getDescricao());
    produto.setCategoria(produtoRequest.getCategoria());
    
    produtoDatabaseGateway.save(produto);
  }
  
}
