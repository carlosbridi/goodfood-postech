package com.good.food.usecase.produto;

import com.good.food.domain.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BuscarProduto {
  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  public Produto execute(String uuid) {
    return produtoDatabaseGateway.findById(UUID.fromString(uuid));
  }
}
