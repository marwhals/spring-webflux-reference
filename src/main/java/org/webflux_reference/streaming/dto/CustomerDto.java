package org.webflux_reference.streaming.dto;

public record CustomerDto(Integer id,
                          String name,
                          String email) {
}