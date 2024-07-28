package com.good.food.usecase.cliente;

import org.springframework.stereotype.Component;
import com.good.food.adapter.gateway.ClienteDatabaseGateway;
import com.good.food.domain.Cliente;
import com.good.food.exception.BussinessValidationException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase {

  private final ClienteDatabaseGateway clienteDatabaseGateway;

  @Override
  public Cliente execute(Cliente cliente) {
    final Cliente clienteSaved = clienteDatabaseGateway.findByCpf(cliente.getCpf());
    if (clienteSaved != null)
      throw new BussinessValidationException("Já existe um cadastro com esse CPF.");
    return clienteDatabaseGateway.save(cliente);
  }
  
}
