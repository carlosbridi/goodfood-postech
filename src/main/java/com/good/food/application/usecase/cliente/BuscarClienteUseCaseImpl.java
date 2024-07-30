package com.good.food.application.usecase.cliente;

import java.util.Optional;

import com.good.food.application.gateway.ClienteDatabaseGateway;
import com.good.food.domain.Cliente;

public class BuscarClienteUseCaseImpl implements BuscarClienteUseCase {
  
  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public BuscarClienteUseCaseImpl(ClienteDatabaseGateway clienteDatabaseGateway) {
    this.clienteDatabaseGateway = clienteDatabaseGateway;
  }

  public Optional<Cliente> execute(final String cpf) {
    Cliente cliente = clienteDatabaseGateway.findByCpf(cpf);
    if (cliente == null) {
      return Optional.empty();
    }
    return Optional.of(cliente);
  }
  
}
