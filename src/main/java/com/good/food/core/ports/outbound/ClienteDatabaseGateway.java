package com.good.food.core.ports.outbound;

import com.good.food.core.domain.Cliente;

public interface ClienteDatabaseGateway {

  Cliente save(Cliente cliente);
  
  Cliente findByCpf(String cpf);
  
}
