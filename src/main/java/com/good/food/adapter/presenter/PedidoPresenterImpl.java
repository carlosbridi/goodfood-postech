package com.good.food.adapter.presenter;

import com.good.food.application.presenter.pedido.PedidoPresenter;
import com.good.food.application.presenter.pedido.PedidoResponse;
import com.good.food.domain.Pedido;

public class PedidoPresenterImpl implements PedidoPresenter {

    @Override
    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(pedido);
    }
}
