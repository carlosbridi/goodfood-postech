package com.good.food.core.usecase;

import org.springframework.stereotype.Component;
import com.good.food.core.domain.Cliente;
import com.good.food.core.ports.inbound.BuscarClienteUseCase;
import com.good.food.core.ports.outbound.ClienteDatabaseGateway;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarCliente implements BuscarClienteUseCase {
  
  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public Cliente execute(final String cpf) {
    return clienteDatabaseGateway.findByCpf(cpf);
  }
  
}
