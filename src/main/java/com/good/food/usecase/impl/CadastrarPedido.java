package com.good.food.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Pedido;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.api.request.PedidoRequest;
import com.good.food.usecase.BuscarClienteUseCase;
import com.good.food.usecase.CadastrarItemPedidoUseCase;
import com.good.food.usecase.CadastrarPedidoUseCase;
import jakarta.transaction.Transactional;

@Component

public class CadastrarPedido implements CadastrarPedidoUseCase {

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
