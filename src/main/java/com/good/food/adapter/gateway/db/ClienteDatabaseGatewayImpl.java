package com.good.food.adapter.gateway.db;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.adapter.gateway.db.repository.entity.ClienteEntity;
import com.good.food.adapter.gateway.db.repository.ClienteRepository;
import com.good.food.domain.entity.Cliente;
import com.good.food.usecase.gateway.ClienteDatabaseGateway;

@Component
public class ClienteDatabaseGatewayImpl implements ClienteDatabaseGateway {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public Cliente save(Cliente cliente) {
    return clienteRepository.save(new ClienteEntity(cliente)).toDomain();
  }

  @Override
  public Cliente findByCpf(String cpf) {
    final Optional<ClienteEntity> findByCpf = clienteRepository.findByCpf(cpf);
    return findByCpf.isPresent() ? findByCpf.get().toDomain() : null;
  }

}
