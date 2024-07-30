package com.good.food.application.usecase.cliente;

import java.util.Optional;

import com.good.food.domain.Cliente;

public interface BuscarClienteUseCase {

  Optional<Cliente> execute(final String cpf);
  
}
