package com.good.food.usecase.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.gateways.ProdutoDatabaseGateway;
import com.good.food.gateways.api.response.ProdutoResponse;
import com.good.food.usecase.BuscarProdutoPorCategoriaUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarProdutoPorCategoria implements BuscarProdutoPorCategoriaUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public List<ProdutoResponse> execute(String categoria) {
    return CollectionUtils.emptyIfNull(produtoDatabaseGateway.findByCategory(categoria))
        .stream()
        .map(ProdutoResponse::new)
        .collect(Collectors.toList());
  }
}
