package com.good.food.application.usecase.produto;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Produto;
import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EditarProduto implements EditarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;
  
  public void execute(UUID produtoId, Produto produtoEditado) {
    Produto produto = produtoDatabaseGateway.findById(produtoId);
    
    produto.setPreco(produtoEditado.getPreco());
    produto.setDescricao(produtoEditado.getDescricao());
    produto.setCategoria(produtoEditado.getCategoria());
    
    produtoDatabaseGateway.save(produto);
  }
  
}
