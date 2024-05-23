package com.good.food.core.usecase;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Produto;
import com.good.food.core.ports.inbound.BuscarProdutoUseCase;
import com.good.food.core.ports.outbound.ProdutoDatabaseGateway;
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
