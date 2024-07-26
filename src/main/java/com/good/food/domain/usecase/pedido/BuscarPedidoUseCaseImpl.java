package com.good.food.domain.usecase.pedido;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.good.food.domain.gateway.PedidoDatabaseGateway;
import com.good.food.domain.presenter.PedidoPresenter;
import com.good.food.domain.usecase.pedido.response.PedidoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarPedidoUseCaseImpl implements BuscarPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final PedidoPresenter pedidoPresenter;

  @Override
  public PedidoResponse execute(UUID uuid) {
    return pedidoPresenter.toResponse(pedidoDatabaseGateway.findById(uuid));
  }
}
