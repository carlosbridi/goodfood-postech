package com.good.food.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.adapter.controller.web.request.cliente.ClienteRequest;
import com.good.food.adapter.controller.web.response.cliente.ClienteResponse;
import com.good.food.adapter.presenter.ClientePresenter;
import com.good.food.domain.Cliente;
import com.good.food.usecase.cliente.BuscarClienteUseCase;
import com.good.food.usecase.cliente.CadastrarClienteUseCase;

@Component
public class ClienteController {

  @Autowired
  private BuscarClienteUseCase buscarClienteUseCase;
  
  @Autowired 
  private CadastrarClienteUseCase cadastrarClienteUseCase;
  
  @Autowired
  private ClientePresenter clientePresenter;
  
  public Optional<ClienteResponse> buscarCliente(String cpf){
    Optional<Cliente> optCliente = buscarClienteUseCase.execute(cpf);
    return optCliente.isPresent() ? Optional.of(clientePresenter.toResponse(optCliente.get())) : Optional.empty();
  }
  
  public ClienteResponse cadastrarCliente(ClienteRequest clienteRequest) {
    return clientePresenter.toResponse(cadastrarClienteUseCase.execute(clienteRequest.toDomain()));
  }
  
}
