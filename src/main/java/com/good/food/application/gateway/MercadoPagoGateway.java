package com.good.food.application.gateway;

import com.good.food.domain.Pedido;

public interface MercadoPagoGateway {

  String generateQRData(Pedido pedido);
  
}
