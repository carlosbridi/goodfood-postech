package com.good.food.gateways.http.request;

import com.good.food.domain.EStatusPedido;
import com.good.food.domain.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest implements Serializable {

  private String clienteCPF;
  private List<String> produtosUUID;
  
  public Pedido toDomain() {
    return Pedido.builder()
        .dataCriacao(LocalDate.now())
        .dataAtualizacao(LocalDate.now())
        .status(EStatusPedido.RECEBIDO)
        .build();
  }
  
}
