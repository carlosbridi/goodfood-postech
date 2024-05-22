package com.good.food.core.entity;

import java.math.BigDecimal;
import java.util.UUID;
import com.good.food.domain.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String descricao;
  private BigDecimal preco;
  @Enumerated(EnumType.STRING)
  private EProdutoCategoria categoria;
  
  public ProdutoEntity(Produto produto) {
    id = produto.getId();
    descricao = produto.getDescricao();
    preco = produto.getPreco();
    categoria = EProdutoCategoria.getByString(produto.getCategoria());
  }
  
  public Produto toDomain(){
    return Produto.builder()
      .id(id)
      .descricao(descricao)
      .preco(preco)
      .categoria(categoria.toString())
    .build();
  }
}
