package com.demo.customer_service.mapper;

import com.demo.customer_service.dto.CustomerInformation;
import com.demo.customer_service.dto.Holding;
import com.demo.customer_service.entity.Customer;
import com.demo.customer_service.entity.PortfolioItem;

import java.util.List;

public class EntityDtoMapper {

    public static CustomerInformation toCustomerInformation(Customer customer, List<PortfolioItem> items){
        var holdings = items.stream()
                .map(i -> new Holding(i.getTicker(), i.getQuantity()))
                .toList();
        return new CustomerInformation(
                customer.getId(),
                customer.getName(),
                customer.getBalance(),
                holdings
        );
    }

}
