package com.good.food.application.usecase.pedido;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Pedido;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import com.good.food.application.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class RemoverDoPedido implements RemoverDoPedidoUseCase {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  @Autowired
  private final BuscarPedidoUseCase buscarPedido;

  public Pedido execute(final String uuidPedido, final List<String> itemsToBeRemoved) {
    Pedido pedido;

    try {
      pedido = buscarPedido.execute(UUID.fromString(uuidPedido));
    } catch (Exception e) {
      throw new NotFoundException("Pedido não existente.", e);
    }

//    itemsToBeRemoved.forEach(pedido::removerItem);

    return pedidoDatabaseGateway.save(pedido);
  }
}
