package com.good.food.domain;

import java.math.BigDecimal;
import java.util.UUID;
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
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String descricao;
  private BigDecimal preco;
  @Enumerated(EnumType.STRING)
  private EProdutoCategoria categoria;
  
}
