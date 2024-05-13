package com.good.food.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
  @OneToOne(optional = true, fetch = FetchType.LAZY)
  private Cliente cliente;  
  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<ItemPedido> itemPedido = new ArrayList<ItemPedido>();
  
  private LocalDate dataCriacao;
  
  private EStatusPedido status;
  
  public void addItem(final ItemPedido itemPedido) {
    this.itemPedido.add(itemPedido);
  }
}
