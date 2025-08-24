package org.webflux_reference.streaming.dto;

public record ProductDto(Integer id,
                         String description,
                         Integer price) {
}