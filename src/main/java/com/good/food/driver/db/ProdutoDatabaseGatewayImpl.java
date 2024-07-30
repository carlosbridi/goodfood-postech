package com.good.food.driver.db;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.application.gateway.ProdutoDatabaseGateway;
import com.good.food.domain.EProdutoCategoria;
import com.good.food.domain.Produto;
import com.good.food.driver.NotFoundException;
import com.good.food.driver.db.repository.ProdutoRepository;
import com.good.food.driver.db.repository.entity.ProdutoEntity;

@Component
public class ProdutoDatabaseGatewayImpl implements ProdutoDatabaseGateway {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Override
  public Produto save(Produto produto) {
    return produtoRepository.save(new ProdutoEntity(produto)).toDomain();
  }

  @Override
  public void delete(UUID uuid) {
    produtoRepository.deleteById(uuid);
  }

  @Override
  public List<Produto> findByCategory(String category) {
    return CollectionUtils.emptyIfNull(produtoRepository.findByCategoria(EProdutoCategoria.getByString(category)))
        .stream()
        .map(ProdutoEntity::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Produto findById(UUID uuid) {
    return produtoRepository
        .findById(uuid)
        .map(ProdutoEntity::toDomain)
        .orElseThrow(() -> new NotFoundException("Produto não encontrado."));
  }

}
