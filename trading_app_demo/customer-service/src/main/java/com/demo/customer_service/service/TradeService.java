package com.demo.customer_service.service;

import com.demo.customer_service.dto.StockTradeRequest;
import com.demo.customer_service.dto.StockTradeResponse;
import com.demo.customer_service.entity.Customer;
import com.demo.customer_service.entity.PortfolioItem;
import com.demo.customer_service.exceptions.ApplicationExceptions;
import com.demo.customer_service.mapper.EntityDtoMapper;
import com.demo.customer_service.repository.CustomerRepository;
import com.demo.customer_service.repository.PortfolioItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
public class TradeService {

    private final CustomerRepository customerRepository;
    private final PortfolioItemRepository portfolioItemRepository;


    public TradeService(CustomerRepository customerRepository, PortfolioItemRepository portfolioItemRepository) {
        this.customerRepository = customerRepository;
        this.portfolioItemRepository = portfolioItemRepository;
    }

    @Transactional // For atomicity
    public Mono<StockTradeResponse> trade(Integer customerId, StockTradeRequest request) {
        return switch (request.action()) {
            case BUY -> this.buyStock(customerId, request);
            case SELL -> throw new RuntimeException("Not Implemented"); //this.sellStock(customerId, request);
        };
    }

    private Mono<StockTradeResponse> buyStock(Integer customerId, StockTradeRequest request) {
        var customerMono = this.customerRepository.findById(customerId)
                .switchIfEmpty(ApplicationExceptions.customerNotFound(customerId))
                .filter(c -> c.getBalance() >= request.totalPrice())
                .switchIfEmpty(ApplicationExceptions.insufficientBalance(customerId));

        var portfolioItemMono = this.portfolioItemRepository.findByCustomerIdAndTicker(customerId, request.ticker())
                .defaultIfEmpty(EntityDtoMapper.toPortfolioItem(customerId, request.ticker()));



        return customerMono.zipWhen(customer -> portfolioItemMono)
                .flatMap(t -> this.executeBuy(t.getT1(), t.getT2(), request));
    }

    private Mono<StockTradeResponse> executeBuy(Customer customer, PortfolioItem portfolioItem, StockTradeRequest request) {
        customer.setBalance(customer.getBalance() - request.totalPrice());
        portfolioItem.setQuantity(portfolioItem.getQuantity() + request.quantity());
        var response = EntityDtoMapper.toStockTradeResponse(request, customer.getId(), customer.getBalance());
        return Mono.zip(this.customerRepository.save(customer), this.portfolioItemRepository.save(portfolioItem))
                .thenReturn(response);
    }

//    private Mono<StockTradeResponse> sellStock(Integer customerId, StockTradeRequest request) {
//    }

}
