package com.good.food.domain.usecase.cliente;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.Cliente;
import com.good.food.domain.gateway.ClienteDatabaseGateway;
import com.good.food.domain.presenter.ClientePresenter;
import com.good.food.domain.usecase.cliente.response.ClienteResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarClienteUseCaseImpl implements BuscarClienteUseCase {
  
  private final ClienteDatabaseGateway clienteDatabaseGateway;
  private final ClientePresenter clientePresenter;

  public Optional<ClienteResponse> execute(final String cpf) {
    Cliente cliente = clienteDatabaseGateway.findByCpf(cpf);
    if (cliente == null) {
      return Optional.empty();
    }
    return Optional.of(clientePresenter.toResponse(cliente));
  }
  
}
