package com.good.food.domain.usecase.cliente.response;

import java.io.Serializable;
import com.good.food.domain.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse implements Serializable {

  private static final long serialVersionUID = 5033384337768652970L;
  
  private String uuid;
  private String nome;
  private String cpf;
  
  public ClienteResponse(final Cliente cliente) {
    this.uuid = cliente.getId().toString();
    this.nome = cliente.getNome();        
    this.cpf = cliente.getCpf();
  }

}
