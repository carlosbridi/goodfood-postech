package com.good.food.driver.integrations;

import org.springframework.stereotype.Component;
import com.good.food.application.gateway.GoodFoodProductGateway;
import com.good.food.domain.Produto;
import com.good.food.driver.integrations.goodfoodproduct.GoodFoodProductIntegration;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoodFoodProductGatewayImpl implements GoodFoodProductGateway {

  private final GoodFoodProductIntegration goodfoodProductIntegration;
  
  @Override
  public Produto obterProduto(String id) {
    return goodfoodProductIntegration.obterProduto(id).toDomain();
  }

}
