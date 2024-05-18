package com.good.food.gateways;

import com.good.food.domain.Pedido;
import com.good.food.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PedidoDatabaseGatewayImpl implements PedidoDatabaseGateway {

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido findById(String uuid) {
        return findById(UUID.fromString(uuid));
    }

    @Override
    public Pedido findById(UUID uuid) {
        return pedidoRepository.findById(uuid).get();
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
