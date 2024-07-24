package com.good.food.application.usecase;

import com.good.food.adapter.controller.request.ItemPedidoRequest;
import com.good.food.application.entity.ItemPedido;
import com.good.food.application.entity.Pedido;


public interface CadastrarItemPedidoUseCase {

  ItemPedido execute(Pedido pedido, ItemPedidoRequest itemPedidoRequest);

}
