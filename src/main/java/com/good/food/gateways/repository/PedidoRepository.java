package com.good.food.gateways.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

}
