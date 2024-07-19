package com.good.food.gateways.database.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.gateways.database.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

}
