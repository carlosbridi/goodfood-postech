package com.good.food.gateways;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.EProdutoCategoria;
import com.good.food.domain.Produto;
import com.good.food.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoDatabaseGatewayImpl implements ProdutoDatabaseGateway {

  @Autowired
  private final ProdutoRepository produtoRepository;

  @Override
  public Produto save(Produto produto) {
    return produtoRepository.save(produto);
  }

  @Override
  public void delete(UUID uuid) {
    produtoRepository.deleteById(uuid);
  }

  @Override
  public List<Produto> findByCategory(EProdutoCategoria category) {
    return produtoRepository.findByCategoria(category);
  }

  @Override
  public Produto findById(UUID uuid) {
    return produtoRepository.findById(uuid).orElseThrow();
  }
  
}
