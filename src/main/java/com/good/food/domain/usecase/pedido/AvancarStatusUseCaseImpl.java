package com.good.food.domain.usecase.pedido;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.EStatusPedido;
import com.good.food.domain.entity.Pedido;
import com.good.food.domain.gateway.PedidoDatabaseGateway;
import com.good.food.domain.presenter.PedidoPresenter;
import com.good.food.domain.usecase.pedido.response.PedidoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class AvancarStatusUseCaseImpl implements AvancarStatusUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final PedidoPresenter pedidoPresenter;

  public PedidoResponse execute(String pedidoId) {
    final Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
    final EStatusPedido statusPedido = EStatusPedido.getByString(pedidoAtual.getStatus());
    pedidoAtual.setStatus(statusPedido.next().toString());
    return pedidoPresenter.toResponse(pedidoDatabaseGateway.save(pedidoAtual));
  }
}
