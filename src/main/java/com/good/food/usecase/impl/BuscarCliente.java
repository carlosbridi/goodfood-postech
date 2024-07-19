package com.good.food.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domains.Cliente;
import com.good.food.gateways.ClienteDatabaseGateway;
import com.good.food.usecase.BuscarClienteUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarCliente implements BuscarClienteUseCase {
  
  @Autowired
  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public Cliente execute(final String cpf) {
    return clienteDatabaseGateway.findByCpf(cpf);
  }
  
}
