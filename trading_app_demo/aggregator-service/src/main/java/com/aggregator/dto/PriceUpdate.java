package com.aggregator.dto;

import com.customer_service.domain.Ticker;

import java.time.LocalDateTime;

public record PriceUpdate(Ticker ticker,
                          Integer price,
                          LocalDateTime time) {
}