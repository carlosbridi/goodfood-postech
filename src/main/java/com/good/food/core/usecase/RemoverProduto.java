package com.good.food.core.usecase;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.ports.inbound.RemoverProdutoUseCase;
import com.good.food.core.ports.outbound.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RemoverProduto implements RemoverProdutoUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  @Override
  public void execute(UUID produtoId) {
    //check if has using on products before delete
    produtoDatabaseGateway.delete(produtoId);
  }
  
}
