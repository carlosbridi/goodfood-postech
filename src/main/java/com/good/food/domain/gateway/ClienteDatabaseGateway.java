package com.good.food.domain.gateway;

import com.good.food.domain.entity.Cliente;

public interface ClienteDatabaseGateway {

  Cliente save(Cliente cliente);
  
  Cliente findByCpf(String cpf);
  
}
