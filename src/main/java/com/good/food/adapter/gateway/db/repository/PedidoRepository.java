package com.good.food.adapter.gateway.db.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.good.food.adapter.gateway.db.repository.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

    @Query("""
            SELECT p FROM PedidoEntity p 
            WHERE p.status != com.good.food.domain.entity.EStatusPedido.FINALIZADO 
            ORDER BY 
            CASE p.status 
            WHEN com.good.food.domain.entity.EStatusPedido.PRONTO THEN 1 
            WHEN com.good.food.domain.entity.EStatusPedido.EM_PREPARACAO THEN 2 
            WHEN com.good.food.domain.entity.EStatusPedido.RECEBIDO THEN 3 
            ELSE 4 END, p.dataCriacao ASC
            """)
    List<PedidoEntity> findAllByStatusNotFinalizadoOrderByStatusAndDate();

}
