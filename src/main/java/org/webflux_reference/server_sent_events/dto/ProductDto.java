package org.webflux_reference.server_sent_events.dto;

public record ProductDto(Integer id,
                         String description,
                         Integer price) {
}