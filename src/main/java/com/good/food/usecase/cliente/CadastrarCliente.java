package com.good.food.usecase.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.Cliente;
import com.good.food.gateways.ClienteDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarCliente {

  @Autowired
  private final ClienteDatabaseGateway clienteDatabaseGateway; 
  
  public Cliente execute(Cliente cliente) {
    return clienteDatabaseGateway.save(cliente);
  }
  
}
