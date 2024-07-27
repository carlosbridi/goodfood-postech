package com.good.food.adapter.gateway.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.good.food.adapter.gateway.db.repository.entity.ItemPedidoEntity;

import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, UUID> {
}
