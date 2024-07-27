package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.usecase.usecase.pedido.response.PedidoResponse;
import com.good.food.domain.entity.Pedido;
import com.good.food.usecase.presenter.PedidoPresenter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoPresenterImpl implements PedidoPresenter {

    @Override
    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(pedido);
    }
}
