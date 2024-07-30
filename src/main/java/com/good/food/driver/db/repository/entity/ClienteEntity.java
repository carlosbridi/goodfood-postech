package com.good.food.driver.db.repository.entity;

import java.util.UUID;
import com.good.food.domain.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class ClienteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String nome;
  private String cpf;
  
  public ClienteEntity(Cliente cliente) {
    id = cliente.getId();
    nome = cliente.getNome();
    cpf = cliente.getCpf();
  }
  
  public Cliente toDomain() {
    return Cliente.builder()
        .id(id)
        .nome(nome)
        .cpf(cpf)
      .build();
  }
  
}
