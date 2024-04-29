package com.good.food.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Cliente;
import com.good.food.gateways.ClienteDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarCliente {
  
  @Autowired
  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public Cliente findByCpf(final String cpf) {
    return clienteDatabaseGateway.findByCpf(cpf);
  }
  
}
