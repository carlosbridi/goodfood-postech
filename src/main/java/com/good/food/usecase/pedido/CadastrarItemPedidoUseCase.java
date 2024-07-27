package com.good.food.usecase.pedido;

import com.good.food.adapter.controller.web.request.pedido.ItemPedidoRequest;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;

public interface CadastrarItemPedidoUseCase {

  ItemPedido execute(Pedido pedido, ItemPedidoRequest itemPedidoRequest);

}
