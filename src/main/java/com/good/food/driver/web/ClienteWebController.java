package com.good.food.driver.web;

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

import com.good.food.adapter.controller.ClienteController;
import com.good.food.adapter.controller.ClienteControllerImpl;
import com.good.food.adapter.presenter.ClientePresenterImpl;
import com.good.food.application.gateway.ClienteDatabaseGateway;
import com.good.food.application.presenter.cliente.ClientePresenter;
import com.good.food.application.presenter.cliente.ClienteRequest;
import com.good.food.application.presenter.cliente.ClienteResponse;
import com.good.food.application.usecase.cliente.BuscarClienteUseCase;
import com.good.food.application.usecase.cliente.BuscarClienteUseCaseImpl;
import com.good.food.application.usecase.cliente.CadastrarClienteUseCase;
import com.good.food.application.usecase.cliente.CadastrarClienteUseCaseImpl;
import com.good.food.driver.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("cliente")
@Api(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteWebController {

    private final ClienteController clienteController;

    public ClienteWebController(ClienteDatabaseGateway clienteDatabaseGateway) {
        // Os gateways devem ser injetados pelo Spring para o framework inicializar os repositórios.
        // Como a implementação dos gateways está na camada mais externa, isso não quebra nenhuma regra do clean architecture.

        // Aqui essa camada (mais externa) escolhe e instancia as implementações que serão usadas em todas as outras camadas.
        // Para trocar a implementação do banco de dados ou um presenter, por exemplo, basta trocar a instância aqui, que irá impactar apenas nesse controller REST.

        final BuscarClienteUseCase buscarClienteUseCase = new BuscarClienteUseCaseImpl(clienteDatabaseGateway);
        final CadastrarClienteUseCase cadastrarClienteUseCase = new CadastrarClienteUseCaseImpl(clienteDatabaseGateway);
        final ClientePresenter clientePresenter = new ClientePresenterImpl();

        this.clienteController = new ClienteControllerImpl(buscarClienteUseCase, cadastrarClienteUseCase, clientePresenter);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
    })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nome", value = "Nome do cliente", required = true, dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "cpf", value = "CPF do cliente", required = true, dataType = "string", paramType = "body"),
    })
    @Operation(
            summary = "Cadastro do Cliente",
            description = "Cadastra o cliente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Cliente a ser cadastrado",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClienteRequest.class),
                            examples = @ExampleObject(
                                    value = "{ \"nome\": \"João Silva\", \"cpf\": \"123.456.789-00\" }"
                            )
                    )
            )
    )
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        final ClienteResponse clienteResponse = clienteController.cadastrarCliente(clienteRequest);
        return ResponseEntity.created(URI.create("/" + clienteResponse.getUuid())).body(clienteResponse);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/buscar-cpf/{cpf}")
    @Operation(
            summary = "Identificação do Cliente via CPF",
            description = "Procura o cliente pelo CPF",
            parameters = @io.swagger.v3.oas.annotations.Parameter(
                    name = "cpf",
                    description = "CPF do cliente",
                    required = true,
                    example = "123.456.789-00"
            )
    )
    public ResponseEntity<ClienteResponse> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(clienteController.buscarCliente(cpf)
                                                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com o CPF informado")));
    }
}
