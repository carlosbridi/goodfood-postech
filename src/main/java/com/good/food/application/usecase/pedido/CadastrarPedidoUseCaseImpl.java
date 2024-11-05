package com.good.food.application.usecase.pedido;

import java.util.List;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.GoodFoodPaymentGateway;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPagamentoPedido;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarPedidoUseCaseImpl implements CadastrarPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final CadastrarItemPedidoUseCase cadastrarItemPedido;
  private final GoodFoodPaymentGateway goodFoodPaymentGateway;

  @Override
  @Transactional
  public Pedido execute(final Pedido newPedido, List<ItemPedido> itensPedido,
      final String clienteCpf) {
    newPedido.setStatus(EStatusPedido.RECEBIDO);
    newPedido.setStatusPagamento(EStatusPagamentoPedido.PENDENTE);
    
    final Pedido pedidoSaved = pedidoDatabaseGateway.save(newPedido);
    
    itensPedido.forEach(itemPedidoRequest -> {
      pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
    });
    
    final String qrCode = goodFoodPaymentGateway.obterQRCode(pedidoSaved.getId().toString(), pedidoSaved.obterTotalPedido());
    pedidoSaved.setQrData(qrCode);
    
    pedidoDatabaseGateway.save(pedidoSaved);

    return pedidoSaved;
  }
}
