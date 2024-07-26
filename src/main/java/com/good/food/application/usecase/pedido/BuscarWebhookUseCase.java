package com.good.food.application.usecase.pedido;

import java.util.UUID;

import com.good.food.application.entity.Webhook;

public interface BuscarWebhookUseCase {
  Webhook execute(UUID webhook);
}
