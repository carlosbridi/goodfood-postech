package com.good.food.core.entity;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import com.good.food.domain.ItemPedido;
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
public class ItemPedidoEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private PedidoEntity pedido;
  @ManyToOne
  @JoinColumn(name = "produto_id")
  private ProdutoEntity produto;

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
  
  public ItemPedidoEntity(ItemPedido itemPedido) {
    id = itemPedido.getId();
    pedido = new PedidoEntity(itemPedido.getPedido());
    produto = new ProdutoEntity(itemPedido.getProduto());
    observacoes = itemPedido.getObservacoes();
    quantidade = itemPedido.getQuantidade();
    preco = itemPedido.getPreco();
  }
  
  public ItemPedido toDomain() {
    return ItemPedido.builder()
        .id(id)
        .pedido(Optional.ofNullable(pedido).map(PedidoEntity::toDomain).orElse(null))
        .produto(produto.toDomain())
        .preco(preco)
        .quantidade(quantidade)
        .observacoes(observacoes)
      .build();
  }
  
}
