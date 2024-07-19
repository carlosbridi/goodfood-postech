package com.good.food.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.domains.Pedido;
import com.good.food.exceptions.NotFoundException;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.api.request.PedidoRequest;
import com.good.food.usecase.AdicionarAoPedidoUseCase;
import com.good.food.usecase.BuscarPedidoUseCase;
import com.good.food.usecase.CadastrarItemPedidoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdicionarAoPedido implements AdicionarAoPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final BuscarPedidoUseCase buscarPedido;
  private final CadastrarItemPedidoUseCase cadastrarItemPedido;

  @Override
  public Pedido execute(final String uuidPedido, final PedidoRequest pedidoRequest) {
    Pedido pedido;

    try {
      pedido = buscarPedido.execute(UUID.fromString(uuidPedido));
    } catch (Exception e) {
      throw new NotFoundException("Pedido não existente.", e);
    }

    pedidoRequest.getItemPedidos().forEach(itemPedidoRequest -> {
      cadastrarItemPedido.execute(pedido, itemPedidoRequest);
    });

    return pedidoDatabaseGateway.save(pedido);
  }

}
