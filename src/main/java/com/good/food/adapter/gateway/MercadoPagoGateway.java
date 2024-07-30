package com.good.food.adapter.gateway;

import com.good.food.domain.Pedido;

public interface MercadoPagoGateway {

  String generateQRData(Pedido pedido);
  
}
