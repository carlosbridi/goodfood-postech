package com.good.food.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
  
  Optional<Cliente> findByCpf(String cpf);

}
