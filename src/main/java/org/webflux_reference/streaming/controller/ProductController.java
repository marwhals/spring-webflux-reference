package org.webflux_reference.streaming.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.webflux_reference.streaming.dto.ProductDto;
import org.webflux_reference.streaming.dto.UploadResponse;
import org.webflux_reference.streaming.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @PostMapping(value = "upload", consumes = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<UploadResponse> uploadProducts(@RequestBody Flux<ProductDto> flux) {
        log.info("invoked");
        return this.service.saveProducts(flux.doOnNext(dto -> log.info("received: {}", dto)))
                .then(this.service.getProductsCount())
                .map(count -> new UploadResponse(UUID.randomUUID(), count));
    }


}