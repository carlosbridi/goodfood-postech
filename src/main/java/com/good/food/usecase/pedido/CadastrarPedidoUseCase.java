package com.good.food.usecase.pedido;

import com.good.food.domain.Pedido;

public interface CadastrarPedidoUseCase {

  Pedido execute(Pedido pedidoRequest, String cpfCliente );

}
