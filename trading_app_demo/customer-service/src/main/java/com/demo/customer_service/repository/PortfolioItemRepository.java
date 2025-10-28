package com.demo.customer_service.repository;

import com.demo.customer_service.entity.PortfolioItem;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PortfolioItemRepository extends ReactiveCrudRepository<PortfolioItem, Integer> {
}
