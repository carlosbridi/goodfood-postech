package com.good.food.usecase.presenter;

import com.good.food.usecase.usecase.cliente.response.ClienteResponse;
import com.good.food.domain.entity.Cliente;

public interface ClientePresenter {

    ClienteResponse toResponse(Cliente cliente);
}
