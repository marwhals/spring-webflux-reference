package org.webflux_reference.server_sent_events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webflux_reference.server_sent_events.dto.ProductDto;
import org.webflux_reference.server_sent_events.mapper.EntityDtoMapper;
import org.webflux_reference.server_sent_events.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private Sinks.Many<ProductDto> sink;

    public Mono<ProductDto> saveProduct(Mono<ProductDto> mono) {
        return mono.map(EntityDtoMapper::toEntity)
                .flatMap(this.repository::save)
                .map(EntityDtoMapper::toDto)
                .doOnNext(this.sink::tryEmitNext);
    }

    public Flux<ProductDto> productStream() {
        return this.sink.asFlux();
    }

}
