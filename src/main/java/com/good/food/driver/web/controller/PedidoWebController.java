package com.good.food.driver.web.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.good.food.adapter.controller.PedidoController;
import com.good.food.adapter.controller.request.PedidoRequest;
import com.good.food.adapter.controller.response.PedidoResponse;
import com.good.food.application.exception.NotFoundException;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("pedido")
@RequiredArgsConstructor
@Api(value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoWebController {

    private final PedidoController pedidoController;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/regredir-status/{id}")
    public ResponseEntity<PedidoResponse> regredirStatus(@PathVariable String id) {
        PedidoResponse pedidoResponse = pedidoController.regredirStatus(id);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/avancar-status/{id}")
    public ResponseEntity<PedidoResponse> avancarStatus(@PathVariable String id) {
        PedidoResponse pedidoResponse = pedidoController.avancarStatus(id);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping()
    @Operation(summary = "Listar os pedidos.", description = "Retorna todos os pedidos abertos.")
    public ResponseEntity<List<PedidoResponse>> retornarTodosPedidosAbertos() {
        return ResponseEntity.ok().body(pedidoController.retornarTodosPedidosAbertos());
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @ApiImplicitParams({ @ApiImplicitParam(name = "clienteCPF", value = "CPF do cliente", required = true, dataType = "string", paramType = "body"), @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem adicionados", required = true, dataType = "array", paramType = "body"), })
    @Operation(summary = "Checkout do pedido", description = "Cadastra o pedido na fila.")
    public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody @Valid PedidoRequest pedidoRequest) {
        PedidoResponse pedidoResponse = pedidoController.cadastrarPedido(pedidoRequest);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(path = "/{id}/adicionarProduto")
    @ApiImplicitParams({ @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem adicionados", required = true, dataType = "array", paramType = "body"), })
    public ResponseEntity<PedidoResponse> adicionarProduto(@PathVariable String id, @RequestBody @Valid PedidoRequest pedidoRequest) throws NotFoundException {
        PedidoResponse pedidoResponse = pedidoController.adicionarProduto(id, pedidoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    @ApiImplicitParams({ @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem removidos", required = true, dataType = "array", paramType = "body"), })
    public ResponseEntity<PedidoResponse> removerProdutos(@PathVariable String id, @RequestBody List<String> itemsToBeRemoved) throws NotFoundException {
        PedidoResponse pedidoResponse = pedidoController.removerProdutos(id, itemsToBeRemoved);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }
}
