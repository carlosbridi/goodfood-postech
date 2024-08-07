package com.good.food.application.presenter.cliente;

import java.io.Serializable;
import com.good.food.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest implements Serializable {

  private static final long serialVersionUID = -4352095493902632725L;
  
  private String nome;
  private String cpf;
  
  public Cliente toDomain() {
    return Cliente.builder()
        .cpf(cpf)
        .nome(nome)        
      .build();
  }
  
}
