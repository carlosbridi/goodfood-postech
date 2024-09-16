package com.good.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.good.food.driver.db")
@EnableCaching
public class GoodFoodServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(GoodFoodServiceApplication.class, args);
  }

}
