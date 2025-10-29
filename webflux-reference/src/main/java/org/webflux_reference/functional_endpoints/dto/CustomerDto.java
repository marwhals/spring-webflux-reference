package org.webflux_reference.functional_endpoints.dto;

public record CustomerDto(Integer id,
                          String name,
                          String email) {
}