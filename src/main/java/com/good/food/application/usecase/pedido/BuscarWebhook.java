package com.good.food.application.usecase.pedido;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.adapter.gateway.WebhookDatabaseGateway;
import com.good.food.application.entity.Webhook;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarWebhook implements BuscarWebhookUseCase {

  @Autowired
  private final WebhookDatabaseGateway webhookDatabaseGateway;

  @Override
  public Webhook execute(UUID uuid) {
    return webhookDatabaseGateway.findById(uuid);
  }
}
