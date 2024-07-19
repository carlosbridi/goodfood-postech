package com.good.food.usecase;

import com.good.food.domains.Pedido;
import com.good.food.gateways.api.request.PedidoRequest;


public interface CadastrarPedidoUseCase {

  Pedido execute(PedidoRequest pedidoRequest);

}
