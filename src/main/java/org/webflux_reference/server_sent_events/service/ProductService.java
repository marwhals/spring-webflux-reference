package org.webflux_reference.server_sent_events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webflux_reference.server_sent_events.dto.ProductDto;
import org.webflux_reference.server_sent_events.mapper.EntityDtoMapper;
import org.webflux_reference.server_sent_events.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<ProductDto> saveProducts(Flux<ProductDto> flux) {
        return flux.map(EntityDtoMapper::toEntity)
                .as(this.repository::saveAll)
                .map(EntityDtoMapper::toDto);
    }

    public Mono<Long> getProductsCount() {
        return this.repository.count();
    }

    public Flux<ProductDto> allProducts() {
        return this.repository.findAll()
                .map(EntityDtoMapper::toDto);
    }

}
