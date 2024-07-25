package com.good.food.application.usecase.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.adapter.controller.request.PedidoRequest;
import com.good.food.application.entity.Pedido;
import com.good.food.application.usecase.cliente.BuscarClienteUseCase;
import com.good.food.adapter.gateway.PedidoDatabaseGateway;
import jakarta.transaction.Transactional;

@Component

class CadastrarPedido implements CadastrarPedidoUseCase {

  @Autowired
  private PedidoDatabaseGateway pedidoDatabaseGateway;
  @Autowired
  private BuscarClienteUseCase buscarCliente;
  @Autowired
  private CadastrarItemPedidoUseCase cadastrarItemPedido;

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
