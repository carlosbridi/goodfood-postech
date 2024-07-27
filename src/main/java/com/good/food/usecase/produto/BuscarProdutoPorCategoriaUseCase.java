package com.good.food.usecase.produto;

import java.util.List;
import com.good.food.domain.Produto;

public interface BuscarProdutoPorCategoriaUseCase {

    List<Produto> execute(String categoria);
}
