package com.good.food.application.usecase.produto;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarProdutoUseCaseImpl implements BuscarProdutoUseCase {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  @Override
  public Produto execute(String uuid) {
    return produtoDatabaseGateway.findById(UUID.fromString(uuid));
  }
}
