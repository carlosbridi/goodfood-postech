package com.good.food.gateways;

import java.util.List;
import java.util.UUID;
import com.good.food.domain.EProdutoCategoria;
import com.good.food.domain.Produto;

public interface ProdutoDatabaseGateway {

  Produto save(Produto produto);
  
  void delete(UUID uuid);
  
  List<Produto> findByCategory(EProdutoCategoria category);
  
}
