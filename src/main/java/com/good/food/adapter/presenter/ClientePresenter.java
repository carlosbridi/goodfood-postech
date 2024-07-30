package com.good.food.adapter.presenter;

import com.good.food.adapter.controller.web.response.cliente.ClienteResponse;
import com.good.food.domain.Cliente;

public interface ClientePresenter {

    ClienteResponse toResponse(Cliente cliente);
}
