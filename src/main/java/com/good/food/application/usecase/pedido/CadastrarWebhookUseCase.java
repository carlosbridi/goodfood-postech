package com.good.food.application.usecase.pedido;

import com.good.food.application.entity.Webhook;

public interface CadastrarWebhookUseCase {
  Webhook execute(Webhook webhook);
}
