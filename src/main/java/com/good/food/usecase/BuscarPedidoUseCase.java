package com.good.food.usecase;

import java.util.UUID;
import com.good.food.domains.Pedido;


public interface BuscarPedidoUseCase {

  Pedido execute(UUID uuid);

}
