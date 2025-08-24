package org.webflux_reference.streaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webflux_reference.streaming.mapper.EntityDtoMapper;
import org.webflux_reference.streaming.repository.ProductRepository;
import org.webflux_reference.streaming.dto.ProductDto;
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

}
