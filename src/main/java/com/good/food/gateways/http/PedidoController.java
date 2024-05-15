package com.good.food.gateways.http;

import java.net.URI;

import com.good.food.usecase.AvancarStatus;
import com.good.food.usecase.RegredirStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.good.food.gateways.http.request.PedidoRequest;
import com.good.food.gateways.http.response.PedidoResponse;
import com.good.food.usecase.CadastrarPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pedido")
@RequiredArgsConstructor
@Api(value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

  private final CadastrarPedido cadastrarPedido;
  private final AvancarStatus avancarStatus;
  private final RegredirStatus regredirStatus;

  @ApiResponses(
          value = {
                  @ApiResponse(code = 200, message = "Ok"),
                  @ApiResponse(code = 201, message = "Created")
          }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/cadastro")
  public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody @Valid PedidoRequest pedidoRequest){
    final PedidoResponse pedidoResponse = new PedidoResponse(cadastrarPedido.execute(pedidoRequest));
    return ResponseEntity.created(URI.create("/"+pedidoResponse.getId())).body(pedidoResponse);
  }


  @ApiResponses(
          value = {
                  @ApiResponse(code = 200, message = "Ok"),
                  @ApiResponse(code = 201, message = "Created")
          }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/regredir-status/{id}")
  public ResponseEntity<PedidoResponse> regredirStatus(@PathVariable String id){
    final PedidoResponse pedidoResponse = new PedidoResponse(regredirStatus.execute(id));
    return ResponseEntity.created(URI.create("/"+pedidoResponse.getId())).body(pedidoResponse);
  }

  @ApiResponses(
          value = {
                  @ApiResponse(code = 200, message = "Ok"),
                  @ApiResponse(code = 201, message = "Created")
          }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/avancar-status/{id}")
  public ResponseEntity<PedidoResponse> avancarStatus(@PathVariable String id){
    final PedidoResponse pedidoResponse = new PedidoResponse(avancarStatus.execute(id));
    return ResponseEntity.created(URI.create("/"+pedidoResponse.getId())).body(pedidoResponse);
  }

}
