package com.good.food.domain.usecase.pedido;

import com.good.food.domain.usecase.pedido.request.PedidoRequest;
import com.good.food.domain.usecase.pedido.response.PedidoResponse;

public interface CadastrarPedidoUseCase {

  PedidoResponse execute(PedidoRequest pedidoRequest);

}
