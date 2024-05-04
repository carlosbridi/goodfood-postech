package com.good.food.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.domain.EProdutoCategoria;
import com.good.food.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

  List<Produto> findByCategoria(EProdutoCategoria categoria);
  
}
