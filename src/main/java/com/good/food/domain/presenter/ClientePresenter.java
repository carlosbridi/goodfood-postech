package com.good.food.domain.presenter;

import com.good.food.domain.usecase.cliente.response.ClienteResponse;
import com.good.food.domain.entity.Cliente;

public interface ClientePresenter {

    ClienteResponse toResponse(Cliente cliente);
}
