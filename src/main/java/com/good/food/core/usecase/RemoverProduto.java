package com.good.food.core.usecase;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.gateways.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RemoverProduto {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public void execute(UUID produtoId) {
    //check if has using on products before delete
    produtoDatabaseGateway.delete(produtoId);
  }
  
}
