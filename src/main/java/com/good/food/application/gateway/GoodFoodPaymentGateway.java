package com.good.food.application.gateway;

import java.math.BigDecimal;

public interface GoodFoodPaymentGateway {

  String obterQRCode(String idPedido, BigDecimal valor);
  
}
