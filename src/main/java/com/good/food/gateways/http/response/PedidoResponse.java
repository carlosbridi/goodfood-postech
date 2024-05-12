package com.good.food.gateways.http.response;


import com.good.food.domain.Cliente;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {


    private String id;
    private String cpf;
    private List<ItemPedido> itemPedido = new ArrayList<>();
    private LocalDate dataAtualizacao;
    private LocalDate dataCriacao;
    private EStatusPedido status;

    public PedidoResponse(Pedido pedido) {
        this.id = pedido.getId().toString();
        this.cpf = pedido.getCliente().getCpf();
        this.itemPedido = pedido.getItemPedido();
        this.dataAtualizacao = pedido.getDataAtualizacao();
        this.dataCriacao = pedido.getDataCriacao();
        this.status = pedido.getStatus();

    }
}
