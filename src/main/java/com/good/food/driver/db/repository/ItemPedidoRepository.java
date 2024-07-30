package com.good.food.driver.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.good.food.driver.db.repository.entity.ItemPedidoEntity;

import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, UUID> {
}
