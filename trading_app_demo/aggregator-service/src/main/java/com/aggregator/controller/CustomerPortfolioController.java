package com.aggregator.controller;

import com.aggregator.dto.CustomerInformation;
import com.aggregator.dto.StockTradeResponse;
import com.aggregator.dto.TradeRequest;
import com.aggregator.service.CustomerPortfolioService;
import com.aggregator.validator.RequestValidator;
import org.springframework.web.bind.annotation.*;
import org.webflux_reference.spring_r2dbc.entity.Customer;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customers")
public class CustomerPortfolioController {

    private final CustomerPortfolioService customerPortfolioService;

    public CustomerPortfolioController(CustomerPortfolioService customerPortfolioService) {
        this.customerPortfolioService = customerPortfolioService;
    }

    @GetMapping("/{customerId}")
    public Mono<CustomerInformation> getCustomerInformation(@PathVariable Integer customerId) {
        return this.customerPortfolioService.getCustomerInformation(customerId);
    }

    @PostMapping("/{customerId}/trade")
    public Mono<StockTradeResponse> trade(@PathVariable Integer customerId, @RequestBody Mono<TradeRequest> mono){
        return mono.transform(RequestValidator.validate())
                .flatMap(req -> this.customerPortfolioService.trade(customerId, req));
    }

}
