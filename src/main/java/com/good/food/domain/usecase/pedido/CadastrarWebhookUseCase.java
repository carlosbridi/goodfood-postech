package com.good.food.domain.usecase.pedido;

import com.good.food.domain.usecase.pedido.request.WebhookRequest;
import com.good.food.domain.usecase.pedido.response.WebhookResponse;

public interface CadastrarWebhookUseCase {
  WebhookResponse execute(WebhookRequest webhookRequest);
}
