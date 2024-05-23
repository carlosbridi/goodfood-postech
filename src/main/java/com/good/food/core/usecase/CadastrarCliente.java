package com.good.food.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Cliente;
import com.good.food.core.ports.inbound.CadastrarClienteUseCase;
import com.good.food.core.ports.outbound.ClienteDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarCliente implements CadastrarClienteUseCase {

  @Autowired
  private final ClienteDatabaseGateway clienteDatabaseGateway; 
  
  @Override
  public Cliente execute(Cliente cliente) {
    return clienteDatabaseGateway.save(cliente);
  }
  
}
