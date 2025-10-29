package org.webflux_reference.input_validation_error_handling.mapper;

import org.webflux_reference.input_validation_error_handling.dto.CustomerDto;
import org.webflux_reference.input_validation_error_handling.entity.Customer;

public class EntityDtoMapper {

    public static Customer toEntity(CustomerDto dto){
        var customer = new Customer();
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setId(dto.id());
        return customer;
    }

    public static CustomerDto toDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );
    }

}