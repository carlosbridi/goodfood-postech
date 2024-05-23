package com.good.food.core.usecase;

import org.springframework.stereotype.Component;
import com.good.food.adapter.inbound.controller.request.PedidoRequest;
import com.good.food.core.domain.Pedido;
import com.good.food.core.ports.inbound.BuscarClienteUseCase;
import com.good.food.core.ports.inbound.CadastrarItemPedidoUseCase;
import com.good.food.core.ports.inbound.CadastrarPedidoUseCase;
import com.good.food.core.ports.outbound.PedidoDatabaseGateway;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarPedido implements CadastrarPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final BuscarClienteUseCase buscarCliente;
  private final CadastrarItemPedidoUseCase cadastrarItemPedido;

  @Override
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
