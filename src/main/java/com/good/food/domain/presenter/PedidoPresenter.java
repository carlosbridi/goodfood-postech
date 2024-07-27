package com.good.food.domain.presenter;

import com.good.food.domain.usecase.pedido.response.PedidoResponse;
import com.good.food.domain.entity.Pedido;

public interface PedidoPresenter {

    PedidoResponse toResponse(Pedido pedido);
}
