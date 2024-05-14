package com.good.food.gateways.http;

import java.net.URI;
import java.util.List;

import com.good.food.domain.exceptions.NotFoundException;
import com.good.food.gateways.http.response.TodosPedidosResponse;
import com.good.food.usecase.pedido.AdicionarAoPedido;
import com.good.food.usecase.pedido.BuscarTodosPedidosAbertos;
import com.good.food.usecase.pedido.RemoverDoPedido;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.good.food.gateways.http.request.PedidoRequest;
import com.good.food.gateways.http.response.PedidoResponse;
import com.good.food.usecase.pedido.CadastrarPedido;
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

    private final AdicionarAoPedido adicionarAoPedido;

    private final RemoverDoPedido removerDoPedido;

    private final BuscarTodosPedidosAbertos buscarTodosPedidosAbertos;

    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
        }
    )
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping()
    public ResponseEntity<TodosPedidosResponse> retornarTodosPedidosAbertos() {
        final TodosPedidosResponse todosPedidosResponse = new TodosPedidosResponse(buscarTodosPedidosAbertos.execute());
        return ResponseEntity.ok().body(todosPedidosResponse);
    }

    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
        }
    )
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/cadastro")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "clienteCPF", value = "CPF do cliente", required = true, dataType = "string", paramType = "body"),
        @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem adicionados", required = true, dataType = "array", paramType = "body"),})
    public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody @Valid PedidoRequest pedidoRequest) {
        final PedidoResponse pedidoResponse = new PedidoResponse(cadastrarPedido.execute(pedidoRequest));
        return ResponseEntity.created(URI.create("/"+pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
        }
    )
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(path = "/{id}/adicionarProduto")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem adicionados", required = true, dataType = "array", paramType = "body"),})
    public ResponseEntity<PedidoResponse> adicionarProduto(@PathVariable String id, @RequestBody @Valid PedidoRequest pedidoRequest) throws NotFoundException {
        final PedidoResponse pedidoResponse = new PedidoResponse(adicionarAoPedido.execute(id, pedidoRequest));
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }

    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Created")
        }
    )
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/{id}/removerProdutos")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem removidos", required = true, dataType = "array", paramType = "body"),})
    public ResponseEntity<PedidoResponse> removerProdutos(@PathVariable String id, @RequestBody List<String> itemsToBeRemoved) throws NotFoundException {
        final PedidoResponse pedidoResponse = new PedidoResponse(removerDoPedido.execute(id, itemsToBeRemoved));
        return ResponseEntity.status(HttpStatus.OK).body(pedidoResponse);
    }
}
