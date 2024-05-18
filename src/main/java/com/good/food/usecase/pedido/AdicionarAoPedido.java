package com.good.food.usecase.pedido;

import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.domain.exceptions.NotFoundException;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdicionarAoPedido {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final BuscarPedido buscarPedido;
  private final CadastrarItemPedido cadastrarItemPedido;

  public Pedido execute(final String uuidPedido, final PedidoRequest pedidoRequest) {
    Pedido pedido;

    try {
      pedido = buscarPedido.execute(uuidPedido);
    } catch (Exception e) {
      throw new NotFoundException("Pedido não existente.", e);
    }

    pedidoRequest.getItemPedidos().forEach(itemPedidoRequest -> {
      cadastrarItemPedido.execute(pedido, itemPedidoRequest);
    });

    return pedidoDatabaseGateway.save(pedido);
  }

}
