package com.good.food.application.usecase.impl;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.adapter.controller.request.PedidoRequest;
import com.good.food.application.entity.Pedido;
import com.good.food.application.usecase.AdicionarAoPedidoUseCase;
import com.good.food.application.usecase.BuscarPedidoUseCase;
import com.good.food.application.usecase.CadastrarItemPedidoUseCase;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import com.good.food.application.exception.NotFoundException;
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
