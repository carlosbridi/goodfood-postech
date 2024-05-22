package com.good.food.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.core.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
  
  Optional<ClienteEntity> findByCpf(String cpf);

}
