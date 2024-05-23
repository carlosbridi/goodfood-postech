package com.good.food.core.usecase;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Produto;
import com.good.food.core.ports.inbound.EditarProdutoUseCase;
import com.good.food.core.ports.outbound.ProdutoDatabaseGateway;
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
