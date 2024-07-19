package com.good.food.usecase;

import com.good.food.domains.Cliente;

public interface BuscarClienteUseCase {

  Cliente execute(final String cpf);
  
}
