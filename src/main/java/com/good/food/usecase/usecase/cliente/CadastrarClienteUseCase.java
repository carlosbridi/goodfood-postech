package com.good.food.usecase.usecase.cliente;

import com.good.food.usecase.usecase.cliente.request.ClienteRequest;
import com.good.food.usecase.usecase.cliente.response.ClienteResponse;

public interface CadastrarClienteUseCase {

  ClienteResponse execute(ClienteRequest clienteRequest);

}
