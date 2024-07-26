package com.good.food.driver.db;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.adapter.gateway.WebhookDatabaseGateway;
import com.good.food.application.entity.Webhook;
import com.good.food.driver.db.repository.WebhookRepository;
import com.good.food.driver.db.repository.entity.WebhookEntity;

@Component
public class WebhookDatabaseGatewayImpl implements WebhookDatabaseGateway {

    @Autowired
    private WebhookRepository webhookRepository;

    @Override
    public Webhook save(Webhook cliente) {
        return webhookRepository.save(new WebhookEntity(cliente)).toDomain();
    }

    @Override
    public Webhook findById(UUID id) {
        if (id == null) {
            return null;
        }

        final Optional<WebhookEntity> byId = webhookRepository.findById(id);
        return byId.isPresent() ? byId.get().toDomain() : null;
    }

}
