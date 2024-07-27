package com.good.food.adapter.gateway.db;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.adapter.PedidoDatabaseGateway;
import com.good.food.adapter.gateway.db.repository.PedidoRepository;
import com.good.food.adapter.gateway.db.repository.entity.PedidoEntity;
import com.good.food.domain.Pedido;
import com.good.food.exception.NotFoundException;

@Component
public class PedidoDatabaseGatewayImpl implements PedidoDatabaseGateway {

  @Autowired
  private PedidoRepository pedidoRepository;

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
  public List<Pedido> findAllByStatusNotFinalizadoOrderByStatusAndDate() {
    return CollectionUtils.emptyIfNull(pedidoRepository.findAllByStatusNotFinalizadoOrderByStatusAndDate())
        .stream()
        .map(PedidoEntity::toDomain)
      .collect(Collectors.toList());
  }
}
