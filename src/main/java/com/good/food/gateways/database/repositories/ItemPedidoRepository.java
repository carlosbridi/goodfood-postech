package com.good.food.gateways.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.gateways.database.entity.ItemPedidoEntity;
import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, UUID> {
}
