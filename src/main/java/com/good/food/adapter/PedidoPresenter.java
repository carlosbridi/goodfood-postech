package com.good.food.adapter;

import com.good.food.adapter.controller.web.response.pedido.PedidoResponse;
import com.good.food.domain.Pedido;

public interface PedidoPresenter {

    PedidoResponse toResponse(Pedido pedido);
}
