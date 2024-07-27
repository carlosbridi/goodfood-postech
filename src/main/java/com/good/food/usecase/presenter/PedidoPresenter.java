package com.good.food.usecase.presenter;

import com.good.food.usecase.usecase.pedido.response.PedidoResponse;
import com.good.food.domain.entity.Pedido;

public interface PedidoPresenter {

    PedidoResponse toResponse(Pedido pedido);
}
