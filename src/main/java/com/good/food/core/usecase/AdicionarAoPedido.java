package com.good.food.core.usecase;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.adapter.inbound.controller.request.PedidoRequest;
import com.good.food.core.domain.Pedido;
import com.good.food.core.ports.inbound.AdicionarAoPedidoUseCase;
import com.good.food.core.ports.inbound.BuscarPedidoUseCase;
import com.good.food.core.ports.inbound.CadastrarItemPedidoUseCase;
import com.good.food.core.ports.outbound.PedidoDatabaseGateway;
import com.good.food.domain.exceptions.NotFoundException;
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
