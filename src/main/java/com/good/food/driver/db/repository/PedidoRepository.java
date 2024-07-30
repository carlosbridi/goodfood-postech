package com.good.food.driver.db.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.good.food.driver.db.repository.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

    @Query("""
            SELECT p FROM PedidoEntity p 
            WHERE p.status != com.good.food.domain.EStatusPedido.FINALIZADO 
            ORDER BY 
            CASE p.status 
            WHEN com.good.food.domain.EStatusPedido.PRONTO THEN 1 
            WHEN com.good.food.domain.EStatusPedido.EM_PREPARACAO THEN 2 
            WHEN com.good.food.domain.EStatusPedido.RECEBIDO THEN 3 
            ELSE 4 END, p.dataCriacao ASC
            """)
    List<PedidoEntity> findAllByStatusNotFinalizadoOrderByStatusAndDate();

}
