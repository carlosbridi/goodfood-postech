package com.good.food.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Pedido {

  private UUID id;
  private Cliente cliente;  
  private List<ItemPedido> itemPedido;
  private LocalDate dataAtualizacao;
  private LocalDate dataCriacao;
  private String status;
  
  public void addItem(final ItemPedido itemPedido) {
    this.itemPedido.add(itemPedido);
  }

  public void removerItem(final String itemToRemove) {
    this.itemPedido.removeIf(itemPedido1 -> itemPedido1.getId().toString().equals(itemToRemove));
  }
  
  
  
}
