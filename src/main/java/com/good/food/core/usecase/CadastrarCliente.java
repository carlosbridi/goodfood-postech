package com.good.food.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Cliente;
import com.good.food.core.ports.inbound.BuscarClienteUseCase;
import com.good.food.core.ports.inbound.CadastrarClienteUseCase;
import com.good.food.core.ports.outbound.ClienteDatabaseGateway;
import com.good.food.domain.exceptions.BussinessValidationException;
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
