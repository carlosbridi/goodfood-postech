package com.good.food.adapter.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.application.presenter.cliente.ClienteRequest;
import com.good.food.application.presenter.cliente.ClienteResponse;
import com.good.food.application.presenter.cliente.ClientePresenter;
import com.good.food.domain.Cliente;
import com.good.food.application.usecase.cliente.BuscarClienteUseCase;
import com.good.food.application.usecase.cliente.CadastrarClienteUseCase;

@Component
public class ClienteControllerImpl implements ClienteController {

  @Autowired
  private BuscarClienteUseCase buscarClienteUseCase;
  
  @Autowired 
  private CadastrarClienteUseCase cadastrarClienteUseCase;
  
  @Autowired
  private ClientePresenter clientePresenter;
  
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
