package com.good.food.usecase.usecase.pedido;

import com.good.food.usecase.usecase.pedido.request.PedidoRequest;
import com.good.food.usecase.usecase.pedido.response.PedidoResponse;

public interface CadastrarPedidoUseCase {

  PedidoResponse execute(PedidoRequest pedidoRequest);

}
