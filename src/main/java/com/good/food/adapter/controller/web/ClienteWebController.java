package com.good.food.adapter.controller.web;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.good.food.domain.exception.NotFoundException;
import com.good.food.domain.usecase.cliente.BuscarClienteUseCase;
import com.good.food.domain.usecase.cliente.CadastrarClienteUseCase;
import com.good.food.domain.usecase.cliente.request.ClienteRequest;
import com.good.food.domain.usecase.cliente.response.ClienteResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cliente")
@RequiredArgsConstructor
@Api(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteWebController {

    private final BuscarClienteUseCase buscarClienteUseCase;
    private final CadastrarClienteUseCase cadastrarClienteUseCase;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Cadastro do Cliente", description = "Cadastra o cliente no banco.")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        final ClienteResponse clienteResponse = cadastrarClienteUseCase.execute(clienteRequest);
        return ResponseEntity.created(URI.create("/" + clienteResponse.getUuid())).body(clienteResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/buscar-cpf/{cpf}")
    @Operation(summary = "Identificação do Cliente via CPF", description = "Procura o cliente pelo CPF")
    public ResponseEntity<ClienteResponse> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(buscarClienteUseCase.execute(cpf) //
                                                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com o CPF informado")));
    }
}
