package com.good.food.domain.presenter;

import com.good.food.domain.usecase.pedido.response.WebhookResponse;
import com.good.food.domain.entity.Webhook;

public interface WebhookPresenter {

    WebhookResponse toResponse(Webhook webhook);
}
