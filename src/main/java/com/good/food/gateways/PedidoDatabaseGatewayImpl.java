package com.good.food.gateways;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import com.good.food.core.entity.PedidoEntity;
import com.good.food.domain.Pedido;
import com.good.food.domain.exceptions.NotFoundException;
import com.good.food.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoDatabaseGatewayImpl implements PedidoDatabaseGateway {

  private final PedidoRepository pedidoRepository;

  @Override
  public Pedido save(Pedido pedido) {
    return pedidoRepository.save(new PedidoEntity(pedido)).toDomain();
  }

  @Override
  public Pedido findById(String uuid) {
    return findById(UUID.fromString(uuid));
  }

  @Override
  public Pedido findById(UUID uuid) {
    return pedidoRepository.findById(uuid)
        .map(PedidoEntity::toDomain)
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
  }

  @Override
  public List<Pedido> findAll() {
    return CollectionUtils.emptyIfNull(pedidoRepository.findAll())
        .stream()
        .map(PedidoEntity::toDomain)
      .collect(Collectors.toList());
  }
}
