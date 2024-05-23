package com.good.food.adapter.outbound.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.adapter.outbound.repository.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
  
  Optional<ClienteEntity> findByCpf(String cpf);

}
