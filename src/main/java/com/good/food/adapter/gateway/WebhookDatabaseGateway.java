package com.good.food.adapter.gateway;

import java.util.UUID;

import com.good.food.application.entity.Webhook;

public interface WebhookDatabaseGateway {

  Webhook save(Webhook webhook);

  Webhook findById(UUID id);
  
}
