package com.good.food.adapter.controller;

import java.util.Optional;

import com.good.food.application.presenter.cliente.ClientePresenter;
import com.good.food.application.presenter.cliente.ClienteRequest;
import com.good.food.application.presenter.cliente.ClienteResponse;
import com.good.food.application.usecase.cliente.BuscarClienteUseCase;
import com.good.food.application.usecase.cliente.CadastrarClienteUseCase;
import com.good.food.domain.Cliente;

public class ClienteControllerImpl implements ClienteController {

  private BuscarClienteUseCase buscarClienteUseCase;
  private CadastrarClienteUseCase cadastrarClienteUseCase;
  private ClientePresenter clientePresenter;

  public ClienteControllerImpl(BuscarClienteUseCase buscarClienteUseCase, CadastrarClienteUseCase cadastrarClienteUseCase, ClientePresenter clientePresenter) {
    this.buscarClienteUseCase = buscarClienteUseCase;
    this.cadastrarClienteUseCase = cadastrarClienteUseCase;
    this.clientePresenter = clientePresenter;
  }

  @Override
  public Optional<ClienteResponse> buscarCliente(String cpf){
    Optional<Cliente> optCliente = buscarClienteUseCase.execute(cpf);
    return optCliente.isPresent() ? Optional.of(clientePresenter.toResponse(optCliente.get())) : Optional.empty();
  }

  @Override
  public ClienteResponse cadastrarCliente(ClienteRequest clienteRequest) {
    return clientePresenter.toResponse(cadastrarClienteUseCase.execute(clienteRequest.toDomain()));
  }

}
