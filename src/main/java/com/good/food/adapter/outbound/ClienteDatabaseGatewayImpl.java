package com.good.food.adapter.outbound;

import org.springframework.stereotype.Component;
import com.good.food.core.domain.Cliente;
import com.good.food.core.ports.outbound.ClienteDatabaseGateway;

@Component
public class ClienteDatabaseGatewayImpl implements ClienteDatabaseGateway {

//  @Autowired
//  private ClienteRepository clienteRepository;

  @Override
  public Cliente save(Cliente cliente) {
    return null; //clienteRepository.save(new ClienteEntity(cliente)).toDomain();
  }

  @Override
  public Cliente findByCpf(String cpf) {
    return null;
//    final Optional<ClienteEntity> findByCpf = clienteRepository.findByCpf(cpf);
//    return findByCpf.isPresent() ? findByCpf.get().toDomain() : null;
  }

}
