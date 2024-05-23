package com.good.food.core.usecase;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.core.domain.Cliente;
import com.good.food.core.ports.inbound.BuscarClienteUseCase;
import com.good.food.core.ports.outbound.ClienteDatabaseGateway;
import com.good.food.domain.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarCliente implements BuscarClienteUseCase {
  
  @Autowired
  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public Cliente execute(final String cpf) {
    return Optional.ofNullable(clienteDatabaseGateway.findByCpf(cpf))
        .orElseThrow(() -> new NotFoundException("Cliente não encontrado com o CPF informado."));
  }
  
}
