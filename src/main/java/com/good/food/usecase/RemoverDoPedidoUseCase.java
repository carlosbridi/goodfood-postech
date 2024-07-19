package com.good.food.usecase;

import java.util.List;
import com.good.food.domains.Pedido;

public interface RemoverDoPedidoUseCase {

  Pedido execute(final String uuidPedido, final List<String> itemsToBeRemoved);
  
}
