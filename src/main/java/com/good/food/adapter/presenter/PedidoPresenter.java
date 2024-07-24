package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.response.PedidoResponse;
import com.good.food.application.entity.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoPresenter {

    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(pedido);
    }
}
