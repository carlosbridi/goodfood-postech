package com.good.food.adapter.controller.response;

import java.io.Serializable;
import java.util.UUID;

import com.good.food.application.entity.Webhook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebhookResponse implements Serializable {

  private static final long serialVersionUID = 5033384337768652970L;

  private UUID id;
  private String url;
  private UUID pedidoId;

  public WebhookResponse(final Webhook webhook) {
    this.id = webhook.getId();
    this.url = webhook.getUrl();
    this.pedidoId = webhook.getPedido().getId();
  }

}
