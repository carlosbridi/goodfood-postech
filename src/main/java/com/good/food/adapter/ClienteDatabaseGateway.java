package com.good.food.adapter;

import com.good.food.domain.Cliente;

public interface ClienteDatabaseGateway {

  Cliente save(Cliente cliente);
  
  Cliente findByCpf(String cpf);
  
}
