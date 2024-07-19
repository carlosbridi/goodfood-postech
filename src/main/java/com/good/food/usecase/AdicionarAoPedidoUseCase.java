package com.good.food.usecase;

import com.good.food.domains.Pedido;
import com.good.food.gateways.api.request.PedidoRequest;


public interface AdicionarAoPedidoUseCase {

  Pedido execute(String uuidPedido, PedidoRequest pedidoRequest);

}
