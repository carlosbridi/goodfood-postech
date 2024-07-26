package com.good.food.domain.usecase.cliente;

import com.good.food.domain.usecase.cliente.request.ClienteRequest;
import com.good.food.domain.usecase.cliente.response.ClienteResponse;

public interface CadastrarClienteUseCase {

  ClienteResponse execute(ClienteRequest clienteRequest);

}
