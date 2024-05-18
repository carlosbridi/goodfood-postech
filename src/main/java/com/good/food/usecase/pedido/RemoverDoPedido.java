package com.good.food.usecase.pedido;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.domain.exceptions.NotFoundException;
import com.good.food.gateways.PedidoDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RemoverDoPedido {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  @Autowired
  private final BuscarPedido buscarPedido;

  public Pedido execute(final String uuidPedido, final List<String> itemsToBeRemoved) {
    Pedido pedido;

    try {
      pedido = buscarPedido.execute(uuidPedido);
    } catch (Exception e) {
      throw new NotFoundException("Pedido não existente.", e);
    }

    itemsToBeRemoved.forEach(pedido::removerItem);

    return pedidoDatabaseGateway.save(pedido);
  }
}
