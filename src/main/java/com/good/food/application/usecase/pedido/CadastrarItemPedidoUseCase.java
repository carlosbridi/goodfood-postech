package com.good.food.application.usecase.pedido;

import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;

public interface CadastrarItemPedidoUseCase {

  ItemPedido execute(Pedido pedido, ItemPedido itemPedido);

}
