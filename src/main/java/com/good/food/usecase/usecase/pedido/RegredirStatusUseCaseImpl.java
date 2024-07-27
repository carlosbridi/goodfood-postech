package com.good.food.usecase.usecase.pedido;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.EStatusPedido;
import com.good.food.domain.entity.Pedido;
import com.good.food.usecase.gateway.PedidoDatabaseGateway;
import com.good.food.usecase.presenter.PedidoPresenter;
import com.good.food.usecase.usecase.pedido.response.PedidoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class RegredirStatusUseCaseImpl implements RegredirStatusUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final PedidoPresenter pedidoPresenter;

  public PedidoResponse execute(String pedidoId) {
    final Pedido pedidoAtual = pedidoDatabaseGateway.findById(pedidoId);
    final EStatusPedido statusPedido = pedidoAtual.getStatus();
    pedidoAtual.setStatus(statusPedido.previous());
    return pedidoPresenter.toResponse(pedidoDatabaseGateway.save(pedidoAtual));
  }
}
