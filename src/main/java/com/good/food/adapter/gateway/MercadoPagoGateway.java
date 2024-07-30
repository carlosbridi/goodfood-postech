package com.good.food.usecase.gateway;

import com.good.food.domain.entity.Pedido;

public interface MercadoPagoGateway {

  String generateQRData(Pedido pedido);
  
}
