package com.good.food.gateways;

import com.good.food.domains.Cliente;

public interface ClienteDatabaseGateway {

  Cliente save(Cliente cliente);
  
  Cliente findByCpf(String cpf);
  
}
