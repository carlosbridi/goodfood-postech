package com.good.food.adapter.controller.response;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.good.food.application.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {

  private String id;
  private String cpf;
  private List<ItemPedidoResponse> itemPedido = new ArrayList<>();
  private LocalDate dataAtualizacao;
  private LocalDate dataCriacao;
  private String status;

  public PedidoResponse(Pedido pedido) {
    this.id = pedido.getId().toString();
    this.cpf = Optional.ofNullable(pedido.getCliente()).map(cli -> cli.getCpf()).orElse(null);
    this.itemPedido = pedido.getItemPedido().stream().map(ItemPedidoResponse::new).collect(Collectors.toList());
    this.dataAtualizacao = pedido.getDataAtualizacao();
    this.dataCriacao = pedido.getDataCriacao();
    this.status = pedido.getStatus().toString();
  }
}
