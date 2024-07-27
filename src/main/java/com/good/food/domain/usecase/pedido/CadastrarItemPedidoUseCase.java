package com.good.food.domain.usecase.pedido;

import com.good.food.domain.usecase.pedido.request.ItemPedidoRequest;
import com.good.food.domain.entity.ItemPedido;
import com.good.food.domain.entity.Pedido;


public interface CadastrarItemPedidoUseCase {

  ItemPedido execute(Pedido pedido, ItemPedidoRequest itemPedidoRequest);

}
