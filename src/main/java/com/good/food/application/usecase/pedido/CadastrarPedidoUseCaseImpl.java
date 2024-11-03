package com.good.food.application.usecase.pedido;

import java.util.List;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.MercadoPagoGateway;
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
  private final MercadoPagoGateway mercadoPagoGateway;
  private final CadastrarItemPedidoUseCase cadastrarItemPedido;

  @Override
  @Transactional
  public Pedido execute(final Pedido newPedido, List<ItemPedido> itensPedido,
      final String clienteCpf) {
    newPedido.setStatus(EStatusPedido.RECEBIDO);
    newPedido.setStatusPagamento(EStatusPagamentoPedido.PENDENTE);
    newPedido.setQrData(mercadoPagoGateway.generateQRData(newPedido));

    final Pedido pedidoSaved = pedidoDatabaseGateway.save(newPedido);

    itensPedido.forEach(itemPedidoRequest -> {
      pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
    });

    return pedidoSaved;
  }
}
