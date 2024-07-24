package com.good.food.application.usecase.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.adapter.gateway.ProdutoDatabaseGateway;
import com.good.food.application.entity.Produto;
import com.good.food.application.usecase.BuscarProdutoPorCategoriaUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarProdutoPorCategoria implements BuscarProdutoPorCategoriaUseCase {

  @Autowired
  private final ProdutoDatabaseGateway produtoDatabaseGateway; 
  
  public List<Produto> execute(String categoria) {
    return produtoDatabaseGateway.findByCategory(categoria);
  }
}
