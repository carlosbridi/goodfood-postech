package com.good.food.domain.gateway;

import java.util.UUID;

import com.good.food.domain.entity.Webhook;

public interface WebhookDatabaseGateway {

  Webhook save(Webhook webhook);

  Webhook findById(UUID id);
  
}
