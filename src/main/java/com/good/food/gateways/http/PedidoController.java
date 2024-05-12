package com.good.food.gateways.http;

import com.good.food.domain.ItemPedido;
import com.good.food.gateways.http.request.PedidoRequest;
import com.good.food.gateways.http.response.PedidoResponse;
import com.good.food.repository.ClienteRepository;
import com.good.food.repository.PedidoRepository;
import com.good.food.repository.ProdutoRepository;
import com.good.food.usecase.CadastrarPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pedido")
@RequiredArgsConstructor
@Api(value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

  private final CadastrarPedido cadastrarPedido;
  @Autowired
  private PedidoRepository pedidoRepository;
  @Autowired
  private ProdutoRepository produtoRepository;
  
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Ok"),
          @ApiResponse(code = 201, message = "Created")
      }
  )
  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping(path = "/cadastro")
  public ResponseEntity cadastrarPedido(@RequestBody @Valid PedidoRequest pedidoRequest){
    final PedidoResponse pedidoResponse = new PedidoResponse(cadastrarPedido.execute(pedidoRequest.toDomain()));
    pedidoResponse.setItemPedido(gerarItemPedido(pedidoRequest, pedidoResponse));
    return ResponseEntity.created(URI.create("/"+pedidoResponse.getId())).body(pedidoResponse);
  }

  private List<ItemPedido> gerarItemPedido(PedidoRequest pedidoRequest, PedidoResponse pedidoResponse){
    List<ItemPedido> itemPedidoList = new ArrayList<>(pedidoRequest.getProdutosUUID().size());
    for(String produtoUuid: pedidoRequest.getProdutosUUID()){
      ItemPedido item = new ItemPedido();
      item.setProduto(produtoRepository.findById(UUID.fromString(produtoUuid)).get());
      item.setPedido(pedidoRepository.findById(UUID.fromString(pedidoResponse.getId())).get());
      item.setPreco(item.getProduto().getPreco());
      itemPedidoList.add(item);
    }

    return itemPedidoList;
  }
}
