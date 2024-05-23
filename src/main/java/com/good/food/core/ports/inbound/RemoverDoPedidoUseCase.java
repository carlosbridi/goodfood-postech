package com.good.food.core.ports.inbound;

import java.util.List;
import com.good.food.core.domain.Pedido;

public interface RemoverDoPedidoUseCase {

  Pedido execute(final String uuidPedido, final List<String> itemsToBeRemoved);
  
}
