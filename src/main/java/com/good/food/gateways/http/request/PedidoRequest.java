package com.good.food.gateways.http.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.repository.ClienteRepository;
import com.good.food.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest implements Serializable {

  private static final long serialVersionUID = 8052492168210242514L;

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private ProdutoRepository produtoRepository;

  private String clienteCPF;
  private List<String> produtosUUID;
  
  public Pedido toDomain() {
    return Pedido.builder()
        .cliente(clienteRepository.findByCpf(clienteCPF).get())
        .dataCriacao(LocalDate.now())
        .dataAtualizacao(LocalDate.now())
        .status(EStatusPedido.RECEBIDO)
        .build();
  }
  
}
