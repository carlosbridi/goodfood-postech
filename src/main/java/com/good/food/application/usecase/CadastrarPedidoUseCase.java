package com.good.food.application.usecase;

import com.good.food.adapter.controller.request.PedidoRequest;
import com.good.food.application.entity.Pedido;


public interface CadastrarPedidoUseCase {

  Pedido execute(PedidoRequest pedidoRequest);

}
