package com.good.food.gateways;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.good.food.core.entity.ClienteEntity;
import com.good.food.domain.Cliente;
import com.good.food.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteDatabaseGatewayImpl implements ClienteDatabaseGateway {

  private final ClienteRepository clienteRepository;

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
