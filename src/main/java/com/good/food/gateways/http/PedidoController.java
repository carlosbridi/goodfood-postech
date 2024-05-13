package com.good.food.gateways.http;

import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.gateways.http.request.PedidoRequest;
import com.good.food.gateways.http.response.PedidoResponse;
import com.good.food.usecase.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedido")
@RequiredArgsConstructor
@Api(value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

  private final CadastrarPedido cadastrarPedido;
  private final CadastrarItemPedido cadastrarItemPedido;
  private final BuscarPedido buscarPedido;
  private final BuscarProduto buscarProduto;
  private final BuscarCliente buscarCliente;
  
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
          @ApiResponse(code = 201, message = "Created")
      }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/cadastro")
  public ResponseEntity cadastrarPedido(@RequestBody @Valid PedidoRequest pedidoRequest){
    Pedido pedido = pedidoRequest.toDomain();
    pedido.setCliente(buscarCliente.findByCpf(pedidoRequest.getClienteCPF()));
    final PedidoResponse pedidoResponse = new PedidoResponse(cadastrarPedido.execute(pedido));

    pedidoResponse.setItemPedido(gerarItemPedido(pedidoRequest, pedidoResponse));
    return ResponseEntity.created(URI.create("/"+pedidoResponse.getId())).body(pedidoResponse);
  }

  private List<ItemPedido> gerarItemPedido(PedidoRequest pedidoRequest, PedidoResponse pedidoResponse){
    List<ItemPedido> itemPedidoList = new ArrayList<>(pedidoRequest.getProdutosUUID().size());
    for(String produtoUuid: pedidoRequest.getProdutosUUID()){
      ItemPedido item = new ItemPedido();
      item.setProduto(buscarProduto.execute(produtoUuid));
      item.setPedido(buscarPedido.execute(pedidoResponse.getId()));
      item.setPreco(item.getProduto().getPreco());
      itemPedidoList.add(cadastrarItemPedido.execute(item));
    }
    return itemPedidoList;
  }
}
