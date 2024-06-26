package com.good.food.adapter.inbound.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.good.food.adapter.inbound.controller.request.PedidoRequest;
import com.good.food.adapter.inbound.controller.response.PedidoResponse;
import com.good.food.core.ports.inbound.AdicionarAoPedidoUseCase;
import com.good.food.core.ports.inbound.AvancarStatusUseCase;
import com.good.food.core.ports.inbound.BuscarTodosPedidosAbertosUseCase;
import com.good.food.core.ports.inbound.CadastrarPedidoUseCase;
import com.good.food.core.ports.inbound.RegredirStatusUseCase;
import com.good.food.core.ports.inbound.RemoverDoPedidoUseCase;
import com.good.food.domain.exceptions.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pedido")
@RequiredArgsConstructor
@Api(value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

  private final CadastrarPedidoUseCase cadastrarPedido;
  private final AvancarStatusUseCase avancarStatus;
  private final RegredirStatusUseCase regredirStatus;
  private final AdicionarAoPedidoUseCase adicionarAoPedido;
  private final RemoverDoPedidoUseCase removerDoPedido;
  private final BuscarTodosPedidosAbertosUseCase buscarTodosPedidosAbertos;

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Created")})
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/regredir-status/{id}")
  public ResponseEntity<PedidoResponse> regredirStatus(@PathVariable String id) {
    final PedidoResponse pedidoResponse = new PedidoResponse(regredirStatus.execute(id));
    return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
  }

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Created")})
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/avancar-status/{id}")
  public ResponseEntity<PedidoResponse> avancarStatus(@PathVariable String id) {
    final PedidoResponse pedidoResponse = new PedidoResponse(avancarStatus.execute(id));
    return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
  }

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Created")})
  @ResponseStatus(code = HttpStatus.OK)
  @GetMapping()
  @Operation(summary = "Listar os pedidos.", description = "Retorna todos os pedidos abertos.")
  public ResponseEntity<List<PedidoResponse>> retornarTodosPedidosAbertos() {
    return ResponseEntity.ok().body(
        buscarTodosPedidosAbertos.execute()
        .stream()
        .map(PedidoResponse::new)
        .collect(Collectors.toList()));
  }

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Created")})
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  @ApiImplicitParams({
      @ApiImplicitParam(name = "clienteCPF", value = "CPF do cliente", required = true,
          dataType = "string", paramType = "body"),
      @ApiImplicitParam(name = "produtosUUID",
          value = "Lista com uuid dos produtos a serem adicionados", required = true,
          dataType = "array", paramType = "body"),})
  @Operation(summary = "Fake Checkout", description = "Cadastra o pedido na fila.")
  public ResponseEntity<PedidoResponse> cadastrarPedido(
      @RequestBody @Valid PedidoRequest pedidoRequest) {
    final PedidoResponse pedidoResponse =
        new PedidoResponse(cadastrarPedido.execute(pedidoRequest));
    return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
  }

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Created")})
  @ResponseStatus(code = HttpStatus.OK)
  @PutMapping(path = "/{id}/adicionarProduto")
  @ApiImplicitParams({@ApiImplicitParam(name = "produtosUUID",
      value = "Lista com uuid dos produtos a serem adicionados", required = true,
      dataType = "array", paramType = "body"),})
  public ResponseEntity<PedidoResponse> adicionarProduto(@PathVariable String id,
      @RequestBody @Valid PedidoRequest pedidoRequest) throws NotFoundException {
    final PedidoResponse pedidoResponse =
        new PedidoResponse(adicionarAoPedido.execute(id, pedidoRequest));
    return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
  }

  @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok"),
      @ApiResponse(code = 201, message = "Created")})
  @ResponseStatus(code = HttpStatus.OK)
  @DeleteMapping(path = "/{id}/removerProdutos")
  @ApiImplicitParams({@ApiImplicitParam(name = "produtosUUID",
      value = "Lista com uuid dos produtos a serem removidos", required = true, dataType = "array",
      paramType = "body"),})
  public ResponseEntity<PedidoResponse> removerProdutos(@PathVariable String id,
      @RequestBody List<String> itemsToBeRemoved) throws NotFoundException {
    final PedidoResponse pedidoResponse =
        new PedidoResponse(removerDoPedido.execute(id, itemsToBeRemoved));
    return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
  }
}
