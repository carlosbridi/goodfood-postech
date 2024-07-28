package com.good.food.adapter.gateway;

import com.good.food.domain.Cliente;

public interface ClienteDatabaseGateway {

  Cliente save(Cliente cliente);
  
  Cliente findByCpf(String cpf);
  
}
