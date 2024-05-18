package com.good.food.usecase.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import com.good.food.usecase.cliente.BuscarCliente;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarPedido {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  @Autowired
  private final BuscarCliente buscarCliente;

  @Autowired
  private final CadastrarItemPedido cadastrarItemPedido;

  public Pedido execute(final PedidoRequest pedidoRequest) {

    final Pedido pedido = pedidoRequest.toDomain();
    pedido.setCliente(buscarCliente.findByCpf(pedidoRequest.getClienteCPF()));

    pedidoRequest.getItemPedidos().forEach(itemPedidoRequest -> {
      pedido.addItem(cadastrarItemPedido.execute(pedido, itemPedidoRequest));
    });

    return pedidoDatabaseGateway.save(pedido);
  }

}
