package com.good.food.gateways;

import org.springframework.stereotype.Component;
import com.good.food.domain.Cliente;
import com.good.food.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteDatabaseGatewayImpl implements ClienteDatabaseGateway {

  private final ClienteRepository clienteRepository;

  @Override
  public Cliente save(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  public Cliente findByCpf(String cpf) {
    return clienteRepository.findByCpf(cpf).orElse(null);
  }

}
