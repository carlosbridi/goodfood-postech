package com.good.food.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "pedido_id")
  private UUID id;
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  private Cliente cliente;  
  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ItemPedido> itemPedido = new ArrayList<>();

  private LocalDate dataAtualizacao;
  private LocalDate dataCriacao;
  
  private EStatusPedido status;
  
  public void addItem(final ItemPedido itemPedido) {
    this.itemPedido.add(itemPedido);
  }

  public void removerItem(final String itemToRemove) {
    this.itemPedido.removeIf(itemPedido1 -> itemPedido1.getId().toString().equals(itemToRemove));
  }
}
