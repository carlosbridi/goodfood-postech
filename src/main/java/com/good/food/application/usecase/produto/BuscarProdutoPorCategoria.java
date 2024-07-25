package com.good.food.application.usecase.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
import com.good.food.application.entity.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarProdutoPorCategoria implements BuscarProdutoPorCategoriaUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  @Override
  public List<Produto> execute(String categoria) {
    return produtoDatabaseGateway.findByCategory(categoria);
  }
}
