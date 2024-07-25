package com.good.food.application.usecase.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Cliente;
import com.good.food.adapter.gateway.ClienteDatabaseGateway;
import com.good.food.application.exception.BussinessValidationException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarCliente implements CadastrarClienteUseCase {

  @Autowired
  private final ClienteDatabaseGateway clienteDatabaseGateway; 
  
  @Autowired
  private final BuscarClienteUseCase buscarClienteUseCase;
  
  @Override
  public Cliente execute(Cliente cliente) {
    final Cliente clienteSaved = buscarClienteUseCase.execute(cliente.getCpf());
    if (clienteSaved != null)
      throw new BussinessValidationException("Já existe um cadastro com esse CPF.");
    return clienteDatabaseGateway.save(cliente);
  }
  
}
