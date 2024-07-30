package com.good.food.application.presenter.pedido;

import com.good.food.domain.Pedido;

public interface PedidoPresenter {

    PedidoResponse toResponse(Pedido pedido);
}
