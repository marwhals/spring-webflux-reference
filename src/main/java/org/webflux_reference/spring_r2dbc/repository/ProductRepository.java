package org.webflux_reference.spring_r2dbc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.webflux_reference.spring_r2dbc.entity.Product;
import reactor.core.publisher.Flux;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

    Flux<Product> findByPriceBetween(int from, int to);

    Flux<Product> findBy(Pageable pageable);

}
