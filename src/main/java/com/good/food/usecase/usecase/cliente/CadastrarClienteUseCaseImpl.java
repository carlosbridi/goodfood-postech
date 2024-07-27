package com.good.food.usecase.usecase.cliente;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.Cliente;
import com.good.food.usecase.exception.BussinessValidationException;
import com.good.food.usecase.gateway.ClienteDatabaseGateway;
import com.good.food.usecase.presenter.ClientePresenter;
import com.good.food.usecase.usecase.cliente.request.ClienteRequest;
import com.good.food.usecase.usecase.cliente.response.ClienteResponse;
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
