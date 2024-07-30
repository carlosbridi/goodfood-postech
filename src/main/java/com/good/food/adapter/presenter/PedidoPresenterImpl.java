package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;
import com.good.food.application.presenter.pedido.PedidoResponse;
import com.good.food.application.presenter.pedido.PedidoPresenter;
import com.good.food.domain.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoPresenterImpl implements PedidoPresenter {

    @Override
    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(pedido);
    }
}
