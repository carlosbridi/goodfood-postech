package com.good.food.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.entity.Cliente;
import com.good.food.application.usecase.BuscarClienteUseCase;
import com.good.food.application.usecase.CadastrarClienteUseCase;
import com.good.food.adapter.gateway.ClienteDatabaseGateway;
import com.good.food.application.exception.BussinessValidationException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarCliente implements CadastrarClienteUseCase {

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
