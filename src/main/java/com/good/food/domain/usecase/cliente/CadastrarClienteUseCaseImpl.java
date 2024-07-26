package com.good.food.domain.usecase.cliente;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.Cliente;
import com.good.food.domain.exception.BussinessValidationException;
import com.good.food.domain.gateway.ClienteDatabaseGateway;
import com.good.food.domain.presenter.ClientePresenter;
import com.good.food.domain.usecase.cliente.request.ClienteRequest;
import com.good.food.domain.usecase.cliente.response.ClienteResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase {

  private final ClienteDatabaseGateway clienteDatabaseGateway;
  private final ClientePresenter clientePresenter;

  @Override
  public ClienteResponse execute(ClienteRequest clienteRequest) {
    final Cliente clienteSaved = clienteDatabaseGateway.findByCpf(clienteRequest.getCpf());
    if (clienteSaved != null)
      throw new BussinessValidationException("Já existe um cadastro com esse CPF.");
    final Cliente cliente = clienteDatabaseGateway.save(clienteRequest.toDomain());
    return clientePresenter.toResponse(cliente);
  }
  
}
