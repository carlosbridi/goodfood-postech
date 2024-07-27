package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.domain.usecase.cliente.response.ClienteResponse;
import com.good.food.domain.entity.Cliente;
import com.good.food.domain.presenter.ClientePresenter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientePresenterImpl implements ClientePresenter {

    @Override
    public ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente);
    }
}
