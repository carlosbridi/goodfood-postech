package com.good.food.application.gateway;

import com.good.food.domain.Produto;

public interface GoodFoodProductGateway {

  Produto obterProduto(String id);
  
}
