package com.good.food.usecase.usecase.cliente;

import java.util.Optional;

import com.good.food.usecase.usecase.cliente.response.ClienteResponse;

public interface BuscarClienteUseCase {

  Optional<ClienteResponse> execute(final String cpf);
  
}
