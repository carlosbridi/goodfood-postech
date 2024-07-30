package com.good.food.adapter.controller;

import java.util.Optional;

import com.good.food.application.presenter.cliente.ClienteRequest;
import com.good.food.application.presenter.cliente.ClienteResponse;

public interface ClienteController {

    Optional<ClienteResponse> buscarCliente(String cpf);

    ClienteResponse cadastrarCliente(ClienteRequest clienteRequest);
}
