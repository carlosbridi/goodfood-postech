package com.good.food.application.usecase.pedido;

import org.springframework.stereotype.Service;

import com.good.food.adapter.gateway.WebhookDatabaseGateway;
import com.good.food.application.entity.Webhook;
import com.good.food.application.exception.BussinessValidationException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarWebhook implements CadastrarWebhookUseCase {

  private final BuscarWebhookUseCase buscarWebhookUseCase;
  private final WebhookDatabaseGateway webhookDatabaseGateway;

  @Override
  public Webhook execute(Webhook webhook) {
    final Webhook webhookSaved = buscarWebhookUseCase.execute(webhook.getId());
    if (webhookSaved != null)
      throw new BussinessValidationException("Já existe um cadastro com esse ID.");
    return webhookDatabaseGateway.save(webhook);
  }
}
