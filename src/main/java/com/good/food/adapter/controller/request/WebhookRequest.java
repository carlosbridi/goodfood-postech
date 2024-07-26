package com.good.food.adapter.controller.request;

import java.io.Serializable;
import java.util.UUID;

import com.good.food.application.entity.Pedido;
import com.good.food.application.entity.Webhook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebhookRequest implements Serializable {

  private static final long serialVersionUID = -4352095493902632725L;

  private String url;
  private UUID pedidoId;

  public Webhook toDomain(Pedido pedido) {
    return Webhook.builder()
        .url(url)
        .pedido(pedido)
      .build();
  }

}
