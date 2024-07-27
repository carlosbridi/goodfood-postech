package com.good.food.domain.usecase.pedido;

import java.util.List;

import com.good.food.domain.usecase.pedido.response.PedidoResponse;

public interface BuscarTodosPedidosAbertosUseCase {

  List<PedidoResponse> execute();
  
}
