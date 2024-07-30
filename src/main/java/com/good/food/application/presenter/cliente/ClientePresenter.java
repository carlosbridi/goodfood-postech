package com.good.food.application.presenter.cliente;

import com.good.food.domain.Cliente;

public interface ClientePresenter {

    ClienteResponse toResponse(Cliente cliente);
}
