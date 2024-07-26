package com.good.food.driver.db.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.good.food.driver.db.repository.entity.WebhookEntity;

public interface WebhookRepository extends JpaRepository<WebhookEntity, UUID> {
}
