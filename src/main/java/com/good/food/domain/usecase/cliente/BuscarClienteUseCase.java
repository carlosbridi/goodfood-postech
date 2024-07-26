package com.good.food.domain.usecase.cliente;

import java.util.Optional;

import com.good.food.domain.usecase.cliente.response.ClienteResponse;

public interface BuscarClienteUseCase {

  Optional<ClienteResponse> execute(final String cpf);
  
}
