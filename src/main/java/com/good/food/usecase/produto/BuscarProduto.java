package com.good.food.usecase.produto;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.domain.Produto;
import com.good.food.gateways.ProdutoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarProduto {

  private final ProdutoDatabaseGateway produtoDatabaseGateway;

  public Produto execute(String uuid) {
    return produtoDatabaseGateway.findById(UUID.fromString(uuid));
  }
}
