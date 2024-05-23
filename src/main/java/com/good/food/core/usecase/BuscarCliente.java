package com.good.food.core.usecase;

import org.springframework.stereotype.Component;
import com.good.food.domain.Cliente;
import com.good.food.gateways.ClienteDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarCliente {
  
  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public Cliente execute(final String cpf) {
    return clienteDatabaseGateway.findByCpf(cpf);
  }
  
}
