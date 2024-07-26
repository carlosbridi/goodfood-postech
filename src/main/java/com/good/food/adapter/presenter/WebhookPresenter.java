package com.good.food.adapter.presenter;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.response.WebhookResponse;
import com.good.food.application.entity.Webhook;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebhookPresenter {

    public WebhookResponse toResponse(Webhook webhook) {
        return new WebhookResponse(webhook);
    }
}
