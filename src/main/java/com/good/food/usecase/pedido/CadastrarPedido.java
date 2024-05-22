package com.good.food.usecase.pedido;

import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import com.good.food.usecase.cliente.BuscarCliente;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarPedido {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final BuscarCliente buscarCliente;
  private final CadastrarItemPedido cadastrarItemPedido;

  public Pedido execute(final PedidoRequest pedidoRequest) {
    final Pedido pedido = pedidoRequest.toDomain();
    pedido.setCliente(buscarCliente.execute(pedidoRequest.getClienteCPF()));
    
    // useCase futuro pra pagamento
    pedido.setStatus("RECEBIDO");
    
    pedidoRequest.getItemPedidos()
      .forEach(itemPedidoRequest -> {
        pedido.addItem(cadastrarItemPedido.execute(pedido, itemPedidoRequest));
      });

    return pedidoDatabaseGateway.save(pedido);
  }

}
