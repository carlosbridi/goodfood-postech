package com.good.food.adapter.presenter;

import com.good.food.application.presenter.cliente.ClientePresenter;
import com.good.food.application.presenter.cliente.ClienteResponse;
import com.good.food.domain.Cliente;

public class ClientePresenterImpl implements ClientePresenter {

    @Override
    public ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente);
    }
}
