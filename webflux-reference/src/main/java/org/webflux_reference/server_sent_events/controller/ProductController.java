package org.webflux_reference.server_sent_events.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.webflux_reference.server_sent_events.dto.ProductDto;
import org.webflux_reference.server_sent_events.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;


    @PostMapping
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> mono){
        return this.service.saveProduct(mono);
    }

    @GetMapping(value = "/stream/{maxPrice}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDto> productStream(@PathVariable Integer maxPrice) {
        return this.service.productStream()
                .filter(dto -> dto.price() <= maxPrice);
    }


}