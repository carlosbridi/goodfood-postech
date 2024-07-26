package com.good.food.adapter.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.request.PedidoRequest;
import com.good.food.adapter.controller.request.WebhookRequest;
import com.good.food.adapter.controller.response.PedidoResponse;
import com.good.food.adapter.controller.response.WebhookResponse;
import com.good.food.adapter.presenter.PedidoPresenter;
import com.good.food.adapter.presenter.WebhookPresenter;
import com.good.food.application.entity.Webhook;
import com.good.food.application.usecase.pedido.AvancarStatusUseCase;
import com.good.food.application.usecase.pedido.BuscarPedidoUseCase;
import com.good.food.application.usecase.pedido.BuscarTodosPedidosAbertosUseCase;
import com.good.food.application.usecase.pedido.CadastrarPedidoUseCase;
import com.good.food.application.usecase.pedido.CadastrarWebhookUseCase;
import com.good.food.application.usecase.pedido.RegredirStatusUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoController {

    private final CadastrarPedidoUseCase cadastrarPedido;
    private final AvancarStatusUseCase avancarStatus;
    private final RegredirStatusUseCase regredirStatus;
    private final BuscarTodosPedidosAbertosUseCase buscarTodosPedidosAbertos;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final PedidoPresenter pedidoPresenter;
    private final CadastrarWebhookUseCase cadastrarWebhook;
    private final WebhookPresenter webhookPresenter;

    public PedidoResponse regredirStatus(String id) {
        return pedidoPresenter.toResponse(regredirStatus.execute(id));
    }

    public PedidoResponse avancarStatus(String id) {
        return pedidoPresenter.toResponse(avancarStatus.execute(id));
    }

    public List<PedidoResponse> retornarTodosPedidosAbertos() {
        return buscarTodosPedidosAbertos.execute().stream().map(pedidoPresenter::toResponse).collect(Collectors.toList());
    }

    public PedidoResponse retornarPedidosPorId(UUID id) {
        return pedidoPresenter.toResponse(buscarPedidoUseCase.execute(id));
    }

    public PedidoResponse cadastrarPedido(PedidoRequest pedidoRequest) {
        return pedidoPresenter.toResponse(cadastrarPedido.execute(pedidoRequest));
    }

    public WebhookResponse cadastrarWebhook(WebhookRequest webhookRequest) {
        Webhook webhook = cadastrarWebhook.execute(webhookRequest.toDomain(buscarPedidoUseCase.execute(webhookRequest.getPedidoId())));
        return webhookPresenter.toResponse(webhook);
    }
}
