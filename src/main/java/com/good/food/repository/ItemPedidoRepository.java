package com.good.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.core.entity.ItemPedidoEntity;
import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, UUID> {
}
