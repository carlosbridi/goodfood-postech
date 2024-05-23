package com.good.food.core.domain;

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
  
}
