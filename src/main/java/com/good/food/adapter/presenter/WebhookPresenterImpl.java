package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.domain.usecase.pedido.response.WebhookResponse;
import com.good.food.domain.entity.Webhook;
import com.good.food.domain.presenter.WebhookPresenter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebhookPresenterImpl implements WebhookPresenter {

    @Override
    public WebhookResponse toResponse(Webhook webhook) {
        return new WebhookResponse(webhook);
    }
}
