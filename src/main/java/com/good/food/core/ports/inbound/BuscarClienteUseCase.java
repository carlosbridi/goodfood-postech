package com.good.food.core.ports.inbound;

import com.good.food.core.domain.Cliente;

public interface BuscarClienteUseCase {

  Cliente execute(final String cpf);
  
}
