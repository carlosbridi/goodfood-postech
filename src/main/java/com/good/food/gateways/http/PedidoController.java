package com.good.food.gateways.http;

import java.net.URI;

import com.good.food.usecase.pedido.AdicionarAoPedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @PutMapping(path = "/{id}/adicionarProduto")
    public ResponseEntity<PedidoResponse> adicionarProduto(@PathVariable String id, @RequestBody @Valid PedidoRequest pedidoRequest) {
        final PedidoResponse pedidoResponse = new PedidoResponse(adicionarAoPedido.execute(id, pedidoRequest));
        return ResponseEntity.ok().build();
    }

}
