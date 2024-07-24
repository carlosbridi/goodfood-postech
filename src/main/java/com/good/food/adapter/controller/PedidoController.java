package com.good.food.adapter.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.good.food.adapter.controller.request.PedidoRequest;
import com.good.food.adapter.controller.response.PedidoResponse;
import com.good.food.adapter.presenter.PedidoPresenter;
import com.good.food.application.exception.NotFoundException;
import com.good.food.application.usecase.AdicionarAoPedidoUseCase;
import com.good.food.application.usecase.AvancarStatusUseCase;
import com.good.food.application.usecase.BuscarTodosPedidosAbertosUseCase;
import com.good.food.application.usecase.CadastrarPedidoUseCase;
import com.good.food.application.usecase.RegredirStatusUseCase;
import com.good.food.application.usecase.RemoverDoPedidoUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoController {

    private final CadastrarPedidoUseCase cadastrarPedido;
    private final AvancarStatusUseCase avancarStatus;
    private final RegredirStatusUseCase regredirStatus;
    private final AdicionarAoPedidoUseCase adicionarAoPedido;
    private final RemoverDoPedidoUseCase removerDoPedido;
    private final BuscarTodosPedidosAbertosUseCase buscarTodosPedidosAbertos;
    private final PedidoPresenter pedidoPresenter;

    public PedidoResponse regredirStatus(String id) {
        return pedidoPresenter.toResponse(regredirStatus.execute(id));
    }

    public PedidoResponse avancarStatus(String id) {
        return pedidoPresenter.toResponse(avancarStatus.execute(id));
    }

    public List<PedidoResponse> retornarTodosPedidosAbertos() {
        return buscarTodosPedidosAbertos.execute().stream().map(pedidoPresenter::toResponse).collect(Collectors.toList());
    }

    public PedidoResponse cadastrarPedido(PedidoRequest pedidoRequest) {
        return pedidoPresenter.toResponse(cadastrarPedido.execute(pedidoRequest));
    }

    public PedidoResponse adicionarProduto(String id, PedidoRequest pedidoRequest) throws NotFoundException {
        return pedidoPresenter.toResponse(adicionarAoPedido.execute(id, pedidoRequest));
    }

    public PedidoResponse removerProdutos(String id, List<String> itemsToBeRemoved) throws NotFoundException {
        return pedidoPresenter.toResponse(removerDoPedido.execute(id, itemsToBeRemoved));
    }
}