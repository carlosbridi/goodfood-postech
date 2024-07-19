package com.good.food.usecase;

import com.good.food.domains.ItemPedido;
import com.good.food.domains.Pedido;
import com.good.food.gateways.api.request.ItemPedidoRequest;


public interface CadastrarItemPedidoUseCase {

  ItemPedido execute(Pedido pedido, ItemPedidoRequest itemPedidoRequest);

}
