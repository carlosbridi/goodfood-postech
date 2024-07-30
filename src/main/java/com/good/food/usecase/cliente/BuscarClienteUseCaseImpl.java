package com.good.food.usecase.cliente;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.good.food.adapter.gateway.ClienteDatabaseGateway;
import com.good.food.domain.Cliente;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarClienteUseCaseImpl implements BuscarClienteUseCase {
  
  private final ClienteDatabaseGateway clienteDatabaseGateway;

  public Optional<Cliente> execute(final String cpf) {
    Cliente cliente = clienteDatabaseGateway.findByCpf(cpf);
    if (cliente == null) {
      return Optional.empty();
    }
    return Optional.of(cliente);
  }
  
}
