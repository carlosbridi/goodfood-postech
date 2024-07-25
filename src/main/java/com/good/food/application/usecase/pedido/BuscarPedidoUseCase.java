package com.good.food.application.usecase.pedido;

import java.util.UUID;
import com.good.food.application.entity.Pedido;


public interface BuscarPedidoUseCase {

  Pedido execute(UUID uuid);

}
