package com.good.food.application.usecase.cliente;

import com.good.food.application.gateway.ClienteDatabaseGateway;
import com.good.food.application.usecase.BussinessValidationException;
import com.good.food.domain.Cliente;

public class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase {

  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public CadastrarClienteUseCaseImpl(ClienteDatabaseGateway clienteDatabaseGateway) {
    this.clienteDatabaseGateway = clienteDatabaseGateway;
  }

  @Override
  public Cliente execute(Cliente cliente) {
    final Cliente clienteSaved = clienteDatabaseGateway.findByCpf(cliente.getCpf());
    if (clienteSaved != null)
      throw new BussinessValidationException("Já existe um cadastro com esse CPF.");
    return clienteDatabaseGateway.save(cliente);
  }
  
}
