package com.good.food.application.usecase.pedido;

import java.util.List;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;

public interface CadastrarPedidoUseCase {

  Pedido execute(Pedido pedidoRequest, List<ItemPedido> itensPedido, String cpfCliente );

}
