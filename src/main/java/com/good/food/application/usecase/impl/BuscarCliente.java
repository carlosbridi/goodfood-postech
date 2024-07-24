package com.good.food.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Cliente;
import com.good.food.application.usecase.BuscarClienteUseCase;
import com.good.food.adapter.gateway.ClienteDatabaseGateway;
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
