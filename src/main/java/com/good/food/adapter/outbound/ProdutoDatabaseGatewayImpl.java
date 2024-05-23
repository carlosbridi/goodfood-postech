package com.good.food.adapter.outbound;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import com.good.food.adapter.outbound.repository.ProdutoRepository;
import com.good.food.adapter.outbound.repository.entity.EProdutoCategoria;
import com.good.food.adapter.outbound.repository.entity.ProdutoEntity;
import com.good.food.core.domain.Produto;
import com.good.food.core.ports.outbound.ProdutoDatabaseGateway;
import com.good.food.domain.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoDatabaseGatewayImpl implements ProdutoDatabaseGateway {

  private final ProdutoRepository produtoRepository;

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
