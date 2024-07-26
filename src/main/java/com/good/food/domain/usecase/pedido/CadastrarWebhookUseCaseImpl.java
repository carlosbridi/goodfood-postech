package com.good.food.domain.usecase.pedido;

import org.springframework.stereotype.Service;

import com.good.food.domain.entity.Pedido;
import com.good.food.domain.gateway.PedidoDatabaseGateway;
import com.good.food.domain.gateway.WebhookDatabaseGateway;
import com.good.food.domain.presenter.WebhookPresenter;
import com.good.food.domain.usecase.pedido.request.WebhookRequest;
import com.good.food.domain.usecase.pedido.response.WebhookResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class CadastrarWebhookUseCaseImpl implements CadastrarWebhookUseCase {

    private final WebhookDatabaseGateway webhookDatabaseGateway;
    private final WebhookPresenter webhookPresenter;
    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    @Override
    public WebhookResponse execute(WebhookRequest webhookRequest) {
        final Pedido pedido = pedidoDatabaseGateway.findById(webhookRequest.getPedidoId());
        return webhookPresenter.toResponse(webhookDatabaseGateway.save(webhookRequest.toDomain(pedido)));
    }
}
