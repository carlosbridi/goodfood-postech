package com.good.food.driver.db.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.driver.db.repository.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

}
