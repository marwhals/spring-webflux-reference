package org.webflux_reference.reactive_crud_api.mapper;

import org.webflux_reference.reactive_crud_api.dto.CustomerDto;
import org.webflux_reference.reactive_crud_api.entity.Customer;

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