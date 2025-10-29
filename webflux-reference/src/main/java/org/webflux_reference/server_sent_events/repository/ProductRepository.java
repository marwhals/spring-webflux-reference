package org.webflux_reference.server_sent_events.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.webflux_reference.server_sent_events.entity.Product;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

}