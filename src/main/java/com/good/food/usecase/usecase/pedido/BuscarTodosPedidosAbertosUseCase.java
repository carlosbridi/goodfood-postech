package com.good.food.usecase.usecase.pedido;

import java.util.List;

import com.good.food.usecase.usecase.pedido.response.PedidoResponse;

public interface BuscarTodosPedidosAbertosUseCase {

  List<PedidoResponse> execute();
  
}
