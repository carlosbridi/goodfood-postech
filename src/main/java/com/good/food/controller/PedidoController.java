package com.good.food.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.good.food.adapter.PedidoPresenter;
import com.good.food.adapter.controller.web.request.pedido.ItemPedidoRequest;
import com.good.food.adapter.controller.web.request.pedido.PedidoRequest;
import com.good.food.adapter.controller.web.response.pedido.PedidoResponse;
import com.good.food.usecase.pedido.AvancarStatusUseCase;
import com.good.food.usecase.pedido.BuscarPedidoUseCase;
import com.good.food.usecase.pedido.BuscarTodosPedidosAbertosUseCase;
import com.good.food.usecase.pedido.CadastrarPedidoUseCase;
import com.good.food.usecase.pedido.RegredirStatusUseCase;
import com.good.food.usecase.pedido.WebhookPedidoUseCase;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoController {

  private final CadastrarPedidoUseCase cadastrarPedido;
  private final AvancarStatusUseCase avancarStatus;
  private final RegredirStatusUseCase regredirStatus;
  private final BuscarTodosPedidosAbertosUseCase buscarTodosPedidosAbertos;
  private final BuscarPedidoUseCase buscarPedidoUseCase;
  private final WebhookPedidoUseCase webhookPedidoUseCase;

  private final PedidoPresenter pedidoPresenter;
  
  public PedidoResponse regredirStatus(String id) {
    return pedidoPresenter.toResponse(regredirStatus.execute(id));
  }
  
  public PedidoResponse avancarStatus(String id) {
    return pedidoPresenter.toResponse(avancarStatus.execute(id));
  }
  
  public List<PedidoResponse> retornarTodosPedidosAbertos(){
    return buscarTodosPedidosAbertos.execute().stream()
        .map(ped -> pedidoPresenter.toResponse(ped))
        .collect(Collectors.toList());
  }
  
  public PedidoResponse buscarPedido(String id) { 
      return pedidoPresenter.toResponse(buscarPedidoUseCase.execute(UUID.fromString(id)));
  }
  
  public PedidoResponse cadastrarPedido(PedidoRequest pedidoRequest) {
    return pedidoPresenter.toResponse(cadastrarPedido.execute(pedidoRequest.toDomain(), 
        pedidoRequest.getItemPedidos().stream().map(ItemPedidoRequest::toDomain).collect(Collectors.toList()),
        pedidoRequest.getClienteCPF()));
  }
  
  public PedidoResponse webhookPedido(String idPedido) {
    return pedidoPresenter.toResponse(webhookPedidoUseCase.execute(idPedido));
  }
  
}
