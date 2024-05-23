package com.good.food.core.usecase;

import org.springframework.stereotype.Component;
import com.good.food.domain.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarPedido {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final BuscarCliente buscarCliente;
  private final CadastrarItemPedido cadastrarItemPedido;

  @Transactional
  public Pedido execute(final PedidoRequest pedidoRequest) {
    final Pedido pedido = pedidoRequest.toDomain();
    pedido.setCliente(buscarCliente.execute(pedidoRequest.getClienteCPF()));
    
    // useCase futuro pra pagamento
    pedido.setStatus("RECEBIDO");
    
    final Pedido pedidoSaved = pedidoDatabaseGateway.save(pedido);
    
    pedidoRequest.getItemPedidos()
      .forEach(itemPedidoRequest -> {
        pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
      });

    return pedidoSaved;
  }

}
