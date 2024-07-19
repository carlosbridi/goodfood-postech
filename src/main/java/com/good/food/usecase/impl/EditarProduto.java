package com.good.food.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.domains.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import com.good.food.usecase.EditarProdutoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EditarProduto implements EditarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;
  
  public void execute(UUID produtoId, Produto produtoEditado) {
    Produto produto = produtoDatabaseGateway.findById(produtoId);
    
    produto.setPreco(produtoEditado.getPreco());
    produto.setDescricao(produtoEditado.getDescricao());
    produto.setCategoria(produtoEditado.getCategoria());
    
    produtoDatabaseGateway.save(produto);
  }
  
}
