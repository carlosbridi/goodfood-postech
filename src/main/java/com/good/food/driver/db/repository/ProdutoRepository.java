package com.good.food.driver.db.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.driver.db.repository.entity.ProdutoEntity;
import com.good.food.domain.EProdutoCategoria;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

  List<ProdutoEntity> findByCategoria(EProdutoCategoria categoria);
  
}
