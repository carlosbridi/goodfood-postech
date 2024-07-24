package com.good.food.application.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Produto;
import com.good.food.application.usecase.BuscarProdutoUseCase;
import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
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
