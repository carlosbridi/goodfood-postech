package com.good.food.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cliente {

  private String id;
  private String nome;
  private String cpf;
  
}
