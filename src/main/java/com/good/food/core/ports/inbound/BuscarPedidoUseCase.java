package com.good.food.core.ports.inbound;

import java.util.UUID;
import com.good.food.core.domain.Pedido;


public interface BuscarPedidoUseCase {

  Pedido execute(UUID uuid);

}
