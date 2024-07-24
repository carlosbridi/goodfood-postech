package com.good.food.adapter.controller;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.request.ClienteRequest;
import com.good.food.adapter.controller.response.ClienteResponse;
import com.good.food.adapter.presenter.ClientePresenter;
import com.good.food.application.entity.Cliente;
import com.good.food.application.usecase.BuscarClienteUseCase;
import com.good.food.application.usecase.CadastrarClienteUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteController {

    private final CadastrarClienteUseCase cadastrarCliente;
    private final BuscarClienteUseCase buscarCliente;
    private final ClientePresenter clientePresenter;

    public ClienteResponse cadastrarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = cadastrarCliente.execute(clienteRequest.toDomain());
        return clientePresenter.toResponse(cliente);
    }

    public Optional<ClienteResponse> findByCpf(String cpf) {
        Cliente cliente = buscarCliente.execute(cpf);
        if (cliente == null) {
            return Optional.empty();
        }
        return Optional.of(clientePresenter.toResponse(cliente));
    }
}
