package com.good.food.adapter.outbound;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.adapter.outbound.repository.ClienteRepository;
import com.good.food.adapter.outbound.repository.entity.ClienteEntity;
import com.good.food.core.domain.Cliente;
import com.good.food.core.ports.outbound.ClienteDatabaseGateway;

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
