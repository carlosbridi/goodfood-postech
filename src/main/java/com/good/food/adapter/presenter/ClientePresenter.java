package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.response.ClienteResponse;
import com.good.food.application.entity.Cliente;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientePresenter {

    public ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente);
    }
}
