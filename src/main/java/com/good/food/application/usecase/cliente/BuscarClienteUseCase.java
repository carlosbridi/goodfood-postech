package com.good.food.application.usecase.cliente;

import com.good.food.application.entity.Cliente;

public interface BuscarClienteUseCase {

  Cliente execute(final String cpf);
  
}
