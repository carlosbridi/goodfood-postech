package com.good.food.driver.integrations.goodfoodproduct;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.good.food.driver.integrations.goodfoodproduct.response.ProdutoResponse;

@FeignClient(
    url = "${food.integration.product.url}",
    name = "${food.integration.product.name}"
  )
public interface GoodFoodProductIntegration {

  @GetMapping(path = "/produto")
  public ProdutoResponse obterProduto(@RequestParam String id);  
  
}
