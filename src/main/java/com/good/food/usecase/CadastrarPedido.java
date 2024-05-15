package com.good.food.usecase;

import com.good.food.gateways.http.request.ItemPedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import com.good.food.gateways.PedidoDatabaseGateway;
import com.good.food.gateways.http.request.PedidoRequest;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CadastrarPedido {

  @Autowired
  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  
  @Autowired
  private final BuscarCliente buscarCliente;
  @Autowired
  private final BuscarProduto buscarProduto;
  @Autowired
  private final CadastrarItemPedido cadastrarItemPedido;
  
  public Pedido execute(final PedidoRequest pedidoRequest) {

    final Pedido pedido = pedidoRequest.toDomain();
    pedido.setCliente(buscarCliente.findByCpf(pedidoRequest.getClienteCPF()));
    pedidoDatabaseGateway.save(pedido);

    pedidoRequest.getItemPedidos().forEach(itemPedidoRequest -> {
      pedido.addItem( criarItemPedido(pedido, itemPedidoRequest));
    });
    
    return pedidoDatabaseGateway.save(pedido);
  }
  
  private ItemPedido criarItemPedido(final Pedido pedido, final ItemPedidoRequest itemPedidoRequest) {
    final Produto produto = buscarProduto.execute(itemPedidoRequest.getProdutoUUID());
    
    final ItemPedido itemPedido = itemPedidoRequest.toDomain();
    itemPedido.setProduto(produto);
    itemPedido.setPreco(produto.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade())));
    itemPedido.setPedido(pedido);
    cadastrarItemPedido.execute(itemPedido);
    return itemPedido;
    
  }

}
