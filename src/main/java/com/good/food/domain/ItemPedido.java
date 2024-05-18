package com.good.food.domain;

import java.math.BigDecimal;
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
public class ItemPedido {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;
  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @Column(nullable = true)
  private String observacoes;
  @Column(nullable = true)
  private Integer quantidade;
  private BigDecimal preco;

  public int getQuantidade() {
    if(quantidade == null || quantidade == 0){
      quantidade = 1;
    }
    return quantidade;
  }
}
