package com.good.food.adapter.gateway.db.repository.entity;

import java.util.UUID;

import com.good.food.domain.entity.Webhook;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "webhook")
public class WebhookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String url;
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  private PedidoEntity pedido;

  public WebhookEntity(Webhook webhook) {
    id = webhook.getId();
    url = webhook.getUrl();
    pedido = new PedidoEntity(webhook.getPedido());
  }

  public Webhook toDomain() {
    return Webhook.builder()
            .id(id)
            .url(url)
            .pedido(pedido.toDomain())
            .build();
  }
}
