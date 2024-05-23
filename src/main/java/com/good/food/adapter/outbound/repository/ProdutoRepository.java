package com.good.food.adapter.outbound.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.adapter.outbound.repository.entity.EProdutoCategoria;
import com.good.food.adapter.outbound.repository.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

  List<ProdutoEntity> findByCategoria(EProdutoCategoria categoria);
  
}
