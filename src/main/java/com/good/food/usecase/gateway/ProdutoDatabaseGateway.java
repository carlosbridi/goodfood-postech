package com.good.food.usecase.gateway;

import java.util.List;
import java.util.UUID;
import com.good.food.domain.entity.Produto;

public interface ProdutoDatabaseGateway {

  Produto findById(UUID uuid);
  
  Produto save(Produto produto);
  
  void delete(UUID uuid);
  
  List<Produto> findByCategory(String category);
  
}
