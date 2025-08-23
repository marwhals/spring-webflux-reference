package org.webflux_reference.reactive_crud_api.dto;

public record CustomerDto(Integer id,
                          String name,
                          String email) {
}