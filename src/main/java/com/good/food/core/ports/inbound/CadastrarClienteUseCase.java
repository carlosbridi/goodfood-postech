package com.good.food.core.ports.inbound;

import com.good.food.core.domain.Cliente;


public interface CadastrarClienteUseCase {

  Cliente execute(Cliente cliente);

}
