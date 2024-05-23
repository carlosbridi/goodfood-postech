package com.good.food.core.ports.inbound;

import com.good.food.adapter.inbound.controller.request.ItemPedidoRequest;
import com.good.food.core.domain.ItemPedido;
import com.good.food.core.domain.Pedido;


public interface CadastrarItemPedidoUseCase {

  ItemPedido execute(Pedido pedido, ItemPedidoRequest itemPedidoRequest);

}
