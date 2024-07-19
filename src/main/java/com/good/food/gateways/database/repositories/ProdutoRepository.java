package com.good.food.gateways.database.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.gateways.database.entity.EProdutoCategoria;
import com.good.food.gateways.database.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

  List<ProdutoEntity> findByCategoria(EProdutoCategoria categoria);
  
}
