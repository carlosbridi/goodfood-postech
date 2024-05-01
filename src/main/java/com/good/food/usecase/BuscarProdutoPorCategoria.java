package com.good.food.usecase;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.EProdutoCategoria;
import com.good.food.gateways.ProdutoDatabaseGateway;
import com.good.food.gateways.http.response.ProdutoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarProdutoPorCategoria {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public List<ProdutoResponse> execute(EProdutoCategoria categoria) {
    return CollectionUtils.emptyIfNull(produtoDatabaseGateway.findByCategory(categoria))
        .stream()
        .map(ProdutoResponse::new)
        .collect(Collectors.toList());
  }
}
