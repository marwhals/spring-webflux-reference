package com.aggregator.dto;

import com.customer_service.domain.Ticker;

public record StockPriceResponse(Ticker ticker,
                                 Integer price) {
}