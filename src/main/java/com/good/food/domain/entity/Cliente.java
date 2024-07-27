package com.good.food.domain.entity;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cliente {

  private UUID id;
  private String nome;
  private String cpf;
  
}