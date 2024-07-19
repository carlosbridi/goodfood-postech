package com.good.food.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.domains.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import com.good.food.usecase.BuscarProdutoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarProduto implements BuscarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  @Override
  public Produto execute(String uuid) {
    return produtoDatabaseGateway.findById(UUID.fromString(uuid));
  }
}
