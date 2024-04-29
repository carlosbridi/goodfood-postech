package com.good.food.gateways.http;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.good.food.gateways.http.request.ClienteRequest;
import com.good.food.gateways.http.response.ClienteResponse;
import com.good.food.usecase.BuscarCliente;
import com.good.food.usecase.CadastrarCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Api(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
  
  @Autowired
  private final CadastrarCliente cadastrarCliente;
  
  @Autowired
  private final BuscarCliente buscarCliente;
  
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
          @ApiResponse(code = 201, message = "Created")
      }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/cadastro")
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
  public ResponseEntity<ClienteResponse> findByCpf(@RequestParam String cpf){
    return 
        ResponseEntity.ok().body(new ClienteResponse(buscarCliente.findByCpf(cpf)));
  }  

}
