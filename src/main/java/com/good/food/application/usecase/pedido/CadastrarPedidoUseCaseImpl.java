package com.good.food.application.usecase.pedido;

import java.util.List;

import com.good.food.application.gateway.ClienteDatabaseGateway;
import com.good.food.application.gateway.MercadoPagoGateway;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.EStatusPagamentoPedido;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import jakarta.transaction.Transactional;

public class CadastrarPedidoUseCaseImpl implements CadastrarPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  private final ClienteDatabaseGateway clienteDatabaseGateway;
  private final MercadoPagoGateway mercadoPagoGateway;
  private final CadastrarItemPedidoUseCase cadastrarItemPedido;

    public CadastrarPedidoUseCaseImpl(PedidoDatabaseGateway pedidoDatabaseGateway, ClienteDatabaseGateway clienteDatabaseGateway, MercadoPagoGateway mercadoPagoGateway, CadastrarItemPedidoUseCase cadastrarItemPedido) {
        this.pedidoDatabaseGateway = pedidoDatabaseGateway;
        this.cadastrarItemPedido = cadastrarItemPedido;
        this.clienteDatabaseGateway = clienteDatabaseGateway;
        this.mercadoPagoGateway = mercadoPagoGateway;
    }

    @Override
  @Transactional
  public Pedido execute(final Pedido newPedido, List<ItemPedido> itensPedido, final String clienteCpf) {
      newPedido.setCliente(clienteDatabaseGateway.findByCpf(clienteCpf));

      newPedido.setStatus(EStatusPedido.RECEBIDO);
      newPedido.setStatusPagamento(EStatusPagamentoPedido.PENDENTE);
      newPedido.setQrData(mercadoPagoGateway.generateQRData(newPedido));
      
      final Pedido pedidoSaved = pedidoDatabaseGateway.save(newPedido);

      itensPedido.forEach(itemPedidoRequest -> {
          pedidoSaved.getItemPedido().add(cadastrarItemPedido.execute(pedidoSaved, itemPedidoRequest));
      });

      // TODO pagamento fake

      return pedidoSaved;
  }
}
