package com.good.food.gateways.api.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.good.food.domains.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest implements Serializable {

  private static final long serialVersionUID = 3561784885713114933L;
  
  private String clienteCPF;
  private List<ItemPedidoRequest> itemPedidos;
  
  public Pedido toDomain() {
    return Pedido.builder()
        .dataCriacao(LocalDate.now())
        .dataAtualizacao(LocalDate.now())
        .itemPedido(new ArrayList<>())
        .build();
  }
  
}
