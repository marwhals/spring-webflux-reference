package org.webflux_reference.input_validation_error_handling.dto;

public record CustomerDto(Integer id,
                          String name,
                          String email) {
}