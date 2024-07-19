package com.good.food.gateways.database.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.gateways.database.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
  
  Optional<ClienteEntity> findByCpf(String cpf);

}
