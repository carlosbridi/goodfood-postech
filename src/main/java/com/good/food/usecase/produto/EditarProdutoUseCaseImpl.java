package com.good.food.usecase.produto;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.adapter.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class EditarProdutoUseCaseImpl implements EditarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;
  
  public void execute(UUID id, Produto produtoEdited) {
    Produto produto = produtoDatabaseGateway.findById(id);
    
    produto.setPreco(produtoEdited.getPreco());
    produto.setDescricao(produtoEdited.getDescricao());
    produto.setCategoria(produtoEdited.getCategoria());
    
    produtoDatabaseGateway.save(produto);
  }
  
}
