package com.good.food.gateways.http.response;

import com.good.food.domain.Pedido;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TodosPedidosResponse {

  private ArrayList<PedidoResponse> todosPedidos = new ArrayList<>();

  public TodosPedidosResponse(List<Pedido> pedidos) {
    for (Pedido pedido : pedidos) {
      todosPedidos.add(new PedidoResponse(pedido));
    }
  }
}
