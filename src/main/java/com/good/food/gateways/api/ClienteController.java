package com.good.food.gateways.api;

import java.net.URI;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.good.food.exceptions.NotFoundException;
import com.good.food.gateways.api.request.ClienteRequest;
import com.good.food.gateways.api.response.ClienteResponse;
import com.good.food.usecase.BuscarClienteUseCase;
import com.good.food.usecase.CadastrarClienteUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cliente")
@RequiredArgsConstructor
@Api(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
  
  private final CadastrarClienteUseCase cadastrarCliente;
  private final BuscarClienteUseCase buscarCliente;

  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
          @ApiResponse(code = 201, message = "Created")
      }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  @Operation(summary = "Cadastro do Cliente", description = "Cadastra o cliente no banco.")
  public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest){
    final ClienteResponse clienteResponse = new ClienteResponse(cadastrarCliente.execute(clienteRequest.toDomain()));
    return 
        ResponseEntity.created(URI.create("/"+clienteResponse.getUuid()))
        .body(clienteResponse);
  }

  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
      }
  )
  @ResponseStatus(code = HttpStatus.OK)
  @PostMapping(path = "/buscar-cpf")
  @Operation(summary = "Identificação do Cliente via CPF", description = "Procura o cliente pelo CPF")
  public ResponseEntity<ClienteResponse> findByCpf(@RequestParam String cpf){
    return 
        ResponseEntity.ok().body(Optional.ofNullable(buscarCliente.execute(cpf)).map(ClienteResponse::new)
            .orElseThrow(() -> new NotFoundException("Cliente não encontrado com o CPF informado")));
  }

}
