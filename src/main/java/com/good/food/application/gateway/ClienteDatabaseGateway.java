package com.good.food.application.gateway;

import com.good.food.domain.Cliente;

public interface ClienteDatabaseGateway {

  Cliente save(Cliente cliente);
  
  Cliente findByCpf(String cpf);
  
}
