package com.good.food.adapter.controller.web;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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

import com.good.food.domain.usecase.pedido.AvancarStatusUseCase;
import com.good.food.domain.usecase.pedido.BuscarPedidoUseCase;
import com.good.food.domain.usecase.pedido.BuscarTodosPedidosAbertosUseCase;
import com.good.food.domain.usecase.pedido.CadastrarPedidoUseCase;
import com.good.food.domain.usecase.pedido.CadastrarWebhookUseCase;
import com.good.food.domain.usecase.pedido.RegredirStatusUseCase;
import com.good.food.domain.usecase.pedido.request.PedidoRequest;
import com.good.food.domain.usecase.pedido.request.WebhookRequest;
import com.good.food.domain.usecase.pedido.response.PedidoResponse;
import com.good.food.domain.usecase.pedido.response.WebhookResponse;
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
public class PedidoWebController {

    private final CadastrarPedidoUseCase cadastrarPedido;
    private final AvancarStatusUseCase avancarStatus;
    private final RegredirStatusUseCase regredirStatus;
    private final BuscarTodosPedidosAbertosUseCase buscarTodosPedidosAbertos;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final CadastrarWebhookUseCase cadastrarWebhook;

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/regredir-status/{id}")
    public ResponseEntity<PedidoResponse> regredirStatus(@PathVariable String id) {
        PedidoResponse pedidoResponse = regredirStatus.execute(id);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/avancar-status/{id}")
    public ResponseEntity<PedidoResponse> avancarStatus(@PathVariable String id) {
        PedidoResponse pedidoResponse = avancarStatus.execute(id);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping()
    @Operation(summary = "Listar os pedidos.", description = """
            Lista todos os pedidos, seguindo o critério:
            1. Pronto > Em Preparação > Recebido;
            2. Pedidos mais antigos primeiro e mais novos depois;
            3. Pedidos com status Finalizado não devem aparecer na lista
            """)
    public ResponseEntity<List<PedidoResponse>> retornarTodosPedidosAbertos() {
        return ResponseEntity.ok().body(buscarTodosPedidosAbertos.execute());
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 404, message = "Not Found") })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    @Operation(summary = "Buscar pedido pelo ID.", description = "Retorna o pedido pelo ID.")
    public ResponseEntity<PedidoResponse> retornarPedidosPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(buscarPedidoUseCase.execute(UUID.fromString(id)));
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"), @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @ApiImplicitParams({ @ApiImplicitParam(name = "clienteCPF", value = "CPF do cliente", required = true, dataType = "string", paramType = "body"), @ApiImplicitParam(name = "produtosUUID", value = "Lista com uuid dos produtos a serem adicionados", required = true, dataType = "array", paramType = "body"), })
    @Operation(summary = "Checkout do pedido", description = "Cadastra o pedido na fila.")
    public ResponseEntity<PedidoResponse> cadastrarPedido(@RequestBody @Valid PedidoRequest pedidoRequest) {
        PedidoResponse pedidoResponse = cadastrarPedido.execute(pedidoRequest);
        return ResponseEntity.created(URI.create("/" + pedidoResponse.getId())).body(pedidoResponse);
    }

    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created") })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "/pagamento/webhook")
    @Operation(summary = "Cadastrar webhook de pagamento do pedido", description = "Cadastrar webhook para receber confirmação de pagamento aprovado ou recusado.")
    public ResponseEntity<WebhookResponse> cadastrarWebhook(@RequestBody WebhookRequest webhook) {
        WebhookResponse createdWebhook = cadastrarWebhook.execute(webhook);
        return ResponseEntity.created(URI.create("/" + createdWebhook.getId())).body(createdWebhook);
    }
}
