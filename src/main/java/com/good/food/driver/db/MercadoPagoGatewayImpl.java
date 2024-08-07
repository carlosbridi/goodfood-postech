package com.good.food.driver.db;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.MercadoPagoGateway;
import com.good.food.domain.Pedido;

@Component
public class MercadoPagoGatewayImpl implements MercadoPagoGateway {

  @Override
  public String generateQRData(Pedido pedido) {
    return UUID.randomUUID().toString()
        + "BR.GOV.BCB.PIX2572pix-qr.mercadopago.com/instore/o/v2/"
        + UUID.randomUUID().toString() + "5204" + pedido.obterTotalPedido()
        + "53039865802BR5925Grupo 63 6009SAO PAULO62070503***6304B61D";
  }

}
